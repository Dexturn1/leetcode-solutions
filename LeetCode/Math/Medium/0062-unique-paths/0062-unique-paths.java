class Solution {
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];
        for(int[]row :dp)Arrays.fill(row, -1);
        return solve(m-1, n-1, dp);
    }

    int solve(int row, int col, int [][]dp){

        if(dp[row][col]!= -1) return dp[row][col];
        if(row == 0 || col == 0){
            return 1;
        }

       
            return dp[row][col] = solve(row - 1, col, dp) + solve(row, col -1, dp); 
    
    }
}