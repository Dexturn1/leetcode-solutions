import os, shutil, requests, re
from datetime import datetime

BASE_DIR = "LeetCode"
API_URL = "https://leetcode.com/graphql"

# ------------------ UTILITIES ------------------

def debug(msg):
    print(f"[📘] {msg}")

def is_problem_folder(name):
    return bool(re.match(r"^\d{4}-", name))

def get_slug(folder):
    m = re.match(r"^\d{4}-(.+)$", folder)
    return m.group(1) if m else None

def get_problem_data(slug):
    query = {
        "query": """
        query ($slug: String!) {
          question(titleSlug: $slug) {
            title
            difficulty
            questionFrontendId
            topicTags { name slug }
          }
        }
        """,
        "variables": {"slug": slug}
    }

    try:
        res = requests.post(API_URL, json=query, timeout=10)
        q = res.json()["data"]["question"]

        title = q["title"]
        diff = q["difficulty"]
        qid = q["questionFrontendId"]
        tags = [t["name"].replace(" ", "_") for t in q["topicTags"]]

        return title, diff, qid, tags
    except Exception as e:
        debug(f"⚠️ Failed to fetch tags for {slug}: {e}")
        return slug, "Unknown", "0000", ["Uncategorized"]

def safe_copy(src, dest):
    if os.path.exists(dest):
        shutil.rmtree(dest)
    shutil.copytree(src, dest)

def add_to_topic_readme(topic, title, qid, slug, difficulty):
    topic_dir = os.path.join(BASE_DIR, topic)
    os.makedirs(topic_dir, exist_ok=True)

    readme = os.path.join(topic_dir, "README.md")
    link = f"https://leetcode.com/problems/{slug}/"

    row = f"| {qid} | [{title}]({link}) | {difficulty} |\n"

    if not os.path.exists(readme):
        with open(readme, "w") as f:
            f.write("| # | Problem | Difficulty |\n|---|----------|------------|\n")

    with open(readme, "r+") as f:
        lines = f.readlines()
        if row not in lines:
            f.write(row)

# ------------------ PROCESSING ------------------

def process_problem(root_path, folder, stats, topics_count, unique_slugs):
    slug = get_slug(folder)
    if not slug:
        debug(f"Skipping invalid folder: {folder}")
        return

    full_path = os.path.join(root_path, folder)
    debug(f"🔍 Processing {folder}")

    title, difficulty, qid, tags = get_problem_data(slug)

    # Count difficulty only once per unique problem
    if slug not in unique_slugs:
        unique_slugs.add(slug)
        stats[difficulty] = stats.get(difficulty, 0) + 1

    # Organize into topic → difficulty → folder
    for tag in tags:
        target = os.path.join(BASE_DIR, tag, difficulty, folder)
        os.makedirs(os.path.dirname(target), exist_ok=True)
        safe_copy(full_path, target)

        add_to_topic_readme(tag, title, qid, slug, difficulty)
        topics_count[tag] = topics_count.get(tag, 0) + 1

    debug(f"✔️ Organized into: {tags}")

# ------------------ MAIN SCRIPT ------------------

debug("🚀 Starting LeetCode Auto Organizer")

stats = {"Easy": 0, "Medium": 0, "Hard": 0}
topics_count = {}
unique_slugs = set()

ALL_FOLDERS = []

# 1️⃣ Collect problem folders from anywhere
for root, dirs, files in os.walk(".", topdown=True):
    # Skip organized folders to avoid recursion copying
    if root.startswith(f"./{BASE_DIR}/"):
        # allow only root of LeetCode, not subtopics
        parts = root.split("/")
        if len(parts) > 3:
            continue

    for folder in dirs:
        if is_problem_folder(folder):
            ALL_FOLDERS.append((root, folder))

debug(f"Found {len(ALL_FOLDERS)} problem folders")

# 2️⃣ Process each folder
for root_path, folder in ALL_FOLDERS:
    process_problem(root_path, folder, stats, topics_count, unique_slugs)

# 3️⃣ Clean original problem folders ONLY if safe
for root_path, folder in ALL_FOLDERS:
    full = os.path.join(root_path, folder)
    if os.path.exists(full):
        shutil.rmtree(full)

# 4️⃣ Generate master README
master = os.path.join(BASE_DIR, "README.md")
total = sum(stats.values())
updated_time = datetime.utcnow().strftime("%Y-%m-%d %H:%M UTC")

with open(master, "w") as f:
    f.write(f"# 🧠 LeetCode Auto Tracker\n\n")
    f.write(f"![Solved](https://img.shields.io/badge/Solved-{total}-blue)\n")
    f.write(f"![Easy](https://img.shields.io/badge/Easy-{stats['Easy']}-green)\n")
    f.write(f"![Medium](https://img.shields.io/badge/Medium-{stats['Medium']}-orange)\n")
    f.write(f"![Hard](https://img.shields.io/badge/Hard-{stats['Hard']}-red)\n")
    f.write(f"![Updated](https://img.shields.io/badge/Updated-{updated_time.replace(' ', '%20')}-grey)\n\n")

    f.write("## 📂 Topics Breakdown\n")
    f.write("| Topic | Problems | Link |\n|-------|-----------|------|\n")

    for topic, count in sorted(topics_count.items()):
        f.write(f"| {topic.replace('_',' ')} | {count} | [{topic}](./{topic}/README.md) |\n")

    f.write(f"\n_Last updated on **{updated_time}**_\n")

debug("🎉 All problems organized successfully!")
