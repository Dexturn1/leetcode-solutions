class Solution {
    int dp[];
    public int minCut(String s) {
        int n = s.length();

        dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(0, s)-1;
    }


    int solve(int i, String s){

        if(i == s.length())
            return 0;

        if(dp[i] != -1)return dp[i];

        StringBuilder temp = new StringBuilder();
        int min = Integer.MAX_VALUE;

        for(int j = i; j< s .length(); j++){
            temp.append(s.charAt(j));

            if( isPalindrome(temp.toString()) ){
                int cost = 1 + solve(j+1, s);
                
                min = Math.min(cost, min);
            }
        }

        return dp[i] = min;
    }


    boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while(left<= right){
            
            if(s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }
}