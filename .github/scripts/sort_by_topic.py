import os, shutil, requests, re
from datetime import datetime

BASE_DIR = "LeetCode"
API_URL = "https://leetcode.com/graphql"

# Change this to your GitHub username repo if different
PROFILE_REPO = "../prabhatkapkoti"

def get_slug(folder):
    m = re.search(r"\d{4}-(.+)", folder)
    return m.group(1) if m else None

def get_problem_data(slug):
    q = {
        "query": """query ($slug: String!) {
          question(titleSlug: $slug) {
            title
            difficulty
            questionFrontendId
            topicTags { name slug }
          }
        }""",
        "variables": {"slug": slug}
    }
    try:
        res = requests.post(API_URL, json=q, timeout=10)
        q = res.json()["data"]["question"]
        title = q["title"]
        diff = q["difficulty"]
        qid = q["questionFrontendId"]
        tags = [t["name"].replace(" ", "_") for t in q["topicTags"]]
        return title, diff, qid, tags
    except Exception as e:
        print("⚠️ Error fetching tags for", slug, ":", e)
        return slug, "Unknown", "0000", ["Uncategorized"]

def copy_update(src, dest):
    if os.path.exists(dest):
        shutil.rmtree(dest)
    shutil.copytree(src, dest)

def add_to_topic_readme(topic, title, qid, slug, diff):
    topic_dir = os.path.join(BASE_DIR, topic)
    readme_path = os.path.join(topic_dir, "README.md")

    link = f"https://leetcode.com/problems/{slug}/"
    line = f"| {qid} | [{title}]({link}) | {diff} |\n"

    if not os.path.exists(readme_path):
        with open(readme_path, "w") as f:
            f.write("| # | Problem | Difficulty |\n|---|----------|------------|\n")

    with open(readme_path, "r+") as f:
        lines = f.readlines()
        if line not in lines:
            f.write(line)

stats = {"Easy": 0, "Medium": 0, "Hard": 0}
topics_count = {}

for diff in ["Easy", "Medium", "Hard"]:
    diff_path = os.path.join(BASE_DIR, diff)
    if not os.path.isdir(diff_path):
        continue

    for folder in os.listdir(diff_path):
        slug = get_slug(folder)
        if not slug: continue

        title, difficulty, qid, tags = get_problem_data(slug)
        src = os.path.join(diff_path, folder)

        for tag in tags:
            topic_dir = os.path.join(BASE_DIR, tag, difficulty, folder)
            os.makedirs(os.path.dirname(topic_dir), exist_ok=True)
            copy_update(src, topic_dir)
            add_to_topic_readme(tag, title, qid, slug, difficulty)
            topics_count[tag] = topics_count.get(tag, 0) + 1

        stats[difficulty] = stats.get(difficulty, 0) + 1

# Clean up default LeetHub folders
for d in ["Easy", "Medium", "Hard"]:
    p = os.path.join(BASE_DIR, d)
    if os.path.isdir(p):
        shutil.rmtree(p)

# === Master README ===
master = os.path.join(BASE_DIR, "README.md")
total = sum(stats.values())
last_updated = datetime.utcnow().strftime("%Y-%m-%d %H:%M UTC")

with open(master, "w") as f:
    f.write(f"# 🧠 LeetCode Auto Tracker\n\n")
    f.write(f"![Problems Solved](https://img.shields.io/badge/Problems_Solved-{total}-blue)\n")
    f.write(f"![Easy](https://img.shields.io/badge/Easy-{stats['Easy']}-green)\n")
    f.write(f"![Medium](https://img.shields.io/badge/Medium-{stats['Medium']}-orange)\n")
    f.write(f"![Hard](https://img.shields.io/badge/Hard-{stats['Hard']}-red)\n")
    f.write(f"![Last Updated](https://img.shields.io/badge/Updated-{last_updated.replace(' ', '%20')}-grey)\n\n")

    f.write(f"Total Problems Solved: **{total}**\n\n")
    f.write("## 🧩 By Difficulty\n")
    f.write(f"- 🟢 Easy: {stats['Easy']}\n")
    f.write(f"- 🟠 Medium: {stats['Medium']}\n")
    f.write(f"- 🔴 Hard: {stats['Hard']}\n\n")
    f.write("## 📂 Topics\n")
    f.write("| Topic | Problems | Link |\n|--------|-----------|------|\n")
    for topic, count in sorted(topics_count.items()):
        f.write(f"| {topic.replace('_', ' ')} | {count} | [View]({topic}/README.md) |\n")
    f.write(f"\n_Last updated on **{last_updated}**_\n")

# === Update GitHub Profile README (optional integration)
if os.path.exists(PROFILE_REPO):
    PROFILE_README = os.path.join(PROFILE_REPO, "README.md")
    if os.path.exists(PROFILE_README):
        with open(PROFILE_README, "r") as f:
            content = f.read()
        new_badges = (
            f"![Problems Solved](https://img.shields.io/badge/Problems_Solved-{total}-blue)\n"
            f"![Easy](https://img.shields.io/badge/Easy-{stats['Easy']}-green)\n"
            f"![Medium](https://img.shields.io/badge/Medium-{stats['Medium']}-orange)\n"
            f"![Hard](https://img.shields.io/badge/Hard-{stats['Hard']}-red)\n"
            f"![Last Updated](https://img.shields.io/badge/Updated-{last_updated.replace(' ', '%20')}-grey)"
        )
        updated = re.sub(
            r"!\[Problems Solved\].*?!\[Last Updated\].*?(?=\n|$)",
            new_badges,
            content,
            flags=re.DOTALL
        )
        with open(PROFILE_README, "w") as f:
            f.write(updated)
        print("✅ Profile README badges updated.")
    else:
        print("⚠️ Profile README not found, skipping badge sync.")

