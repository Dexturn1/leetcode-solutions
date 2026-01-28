class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int [][]dp = new int[n][m];
        for(int []row : dp)Arrays.fill(row, -1);

        return solve(n-1, m-1,obstacleGrid,dp);
    }

    int solve(int row, int col, int[][]obstacleGrid, int[][]dp){

        if (row < 0 || col < 0 || obstacleGrid[row][col] == 1) return 0;
        if(row == 0 && col == 0)return 1;
        
        if(dp[row][col] != -1) return dp[row][col];
    
        return dp[row][col] = solve(row-1, col, obstacleGrid, dp) + solve(row, col-1, obstacleGrid, dp);
    }
}