class Solution {
    int [][]dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[]row :dp){
            Arrays.fill(row, -1);
        }

        return solve(m-1, n-1);
    }



    int solve(int i, int j){

        if(dp[i][j]!= -1)return dp[i][j];
        if(i == 0 && j == 0){
            return 1;
        }

        int left= 0; 
        int up= 0;

        if(i > 0){
            up = solve(i-1, j);
        }
        if(j > 0){
            left = solve(i,j-1);
        }

        return dp[i][j] = up+left;
    }
}