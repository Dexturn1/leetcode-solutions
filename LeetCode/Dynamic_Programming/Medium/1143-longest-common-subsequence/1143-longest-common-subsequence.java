class Solution {
    int [][]dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int i = text1.length();
        int j = text2.length();

        dp = new int[i][j];

        for(int []row: dp){
            Arrays.fill(row, -1);
        }
        
        return solve(i-1, j-1, text1, text2);     

    }
        
    int solve(int i, int j, String s1, String s2){

        if(i == -1 || j == -1)return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if( s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + solve(i-1, j-1, s1, s2);
            
        else
            return dp[i][j] =
            Math.max(
                solve(i-1, j, s1, s2),
                solve(i, j-1, s1, s2)); 
    }
    
}