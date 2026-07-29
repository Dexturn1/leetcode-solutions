class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordSet = new HashSet<>(wordDict);

        Boolean[] memo = new Boolean[s.length()];

        return backtrack(s, wordSet, 0, memo);
    }

    public boolean backtrack(String s,
                             Set<String> wordSet,
                             int start,
                             Boolean[] memo) {

        if (start == s.length())
            return true;

        if (memo[start] != null)
            return memo[start];

        for (int end = start + 1; end <= s.length(); end++) {

            String segment = s.substring(start, end);

            if (wordSet.contains(segment)) {

                if (backtrack(s, wordSet, end, memo)) {

                    memo[start] = true;
                    return true;
                }
            }
        }

        memo[start] = false;
        return false;
    }
}