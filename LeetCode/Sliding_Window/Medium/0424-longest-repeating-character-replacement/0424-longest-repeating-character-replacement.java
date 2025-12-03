class Solution {
    public int characterReplacement(String s, int k) {
        int [] hash = new int[26];
        int maxFreq = 0;
        int maxLength = 0;
        int left = 0;

        for(int right = 0; right<s.length(); right++){

            // Extending window by adding the character
            hash[s.charAt(right) - 'A']++;

            // update the max frequency we have see in the window
            maxFreq = Math.max(maxFreq, hash[s.charAt(right) - 'A']);

            // get the currnt window size
            int windowSize = right - left + 1;

            //  check if the window is valid or unvalid
            if(windowSize - maxFreq > k){
                // shrink the window
                hash[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left +1);
        }

        return maxLength;        
    }
}