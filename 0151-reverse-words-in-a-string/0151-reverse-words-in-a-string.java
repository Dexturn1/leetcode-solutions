class Solution {
    public String reverseWords(String s) {

        // remove leading/trailing spaces and split by multiple spaces
        String[] words = s.trim().split("\\s+");

        StringBuilder sb = new StringBuilder();

        // traverse words from end
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i != 0) sb.append(" ");
        }

        return sb.toString();
    }
}
