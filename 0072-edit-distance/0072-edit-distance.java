class Solution {
    int [][]dp;
    public int minDistance(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        dp = new int[n][m];

        for(int []row: dp)Arrays.fill(row, -1);

        return solve(n-1, m-1, s1, s2);
    }

    int solve(int i, int j, String s1, String s2){

        if(i < 0)return j+1;
        if(j<0)return i+1;

        if(dp[i][j] != -1)return dp[i][j];


        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(i-1, j-1, s1, s2);
        }
        else{

            int del = 1 + solve(i-1, j, s1, s2);
            int replace = 1 + solve(i-1, j-1, s1, s2);
            int insert = 1 + solve(i, j-1, s1, s2);
            return dp[i][j] = Math.min(del, Math.min(replace, insert));
        }
    }
}