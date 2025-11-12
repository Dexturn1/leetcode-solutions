class Solution {
    public int numberOfSubstrings(String s) {
        // Array to store the last seen index of 'a', 'b', and 'c'
        int []lastSeen = {-1, -1, -1};

        // Variable to store total count of valid substrings
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            // 'a' -> index 0, 'b' -> index 1, 'c' -> index 2
            lastSeen[s.charAt(i) - 'a'] = i;

            // Calculate number of valid substrings ending at i
            // Minimum of last seen indices gives the earliest position
            // from where all three chars exist in substring
            count = count + 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
        }

        return count;
    }
}
