class Solution {
    int [][]dp;
    public int longestPalindromeSubseq(String s) {

        int n = s.length();
        dp = new int[n][n];
        for(int []row: dp)
            Arrays.fill(row, -1);
        
       return solve(n-1 , n-1 , s, new StringBuilder(s).reverse().toString()); 
    }


    int solve(int i, int j, String s1, String s2){

        if(i < 0 || j < 0)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        if( s1.charAt(i)  == s2.charAt(j) ){
            return dp[i][j] = 1 + solve(i-1, j-1, s1, s2);
        }else{
            return dp[i][j] = Math.max(
                solve(i-1, j, s1, s2),
                solve(i, j-1, s1, s2)
            );

        }
    }



}