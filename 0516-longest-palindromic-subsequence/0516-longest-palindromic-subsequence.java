class Solution {
    int [][]dp;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        dp = new int[n][n];

        for(int []row: dp)
            Arrays.fill(row, -1);


        return solve(0, s.length()-1, s);
    }


    int solve(int left, int right, String s){
        
        if(left > right)return 0;
        if(left == right)return 1;

        if(dp[left][right] != -1)return dp[left][right];

        if(s.charAt(left) == s.charAt(right)){
            return dp[left][right] = 2 + solve(left+1, right-1, s);

        }else{
            return dp[left][right] = Math.max( solve(left+1, right, s) , solve(left, right-1, s));
        }
    }   
}