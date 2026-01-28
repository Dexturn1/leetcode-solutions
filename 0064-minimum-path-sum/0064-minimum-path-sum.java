class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];
        for(int []row: dp) Arrays.fill(row, -1);

        return solve(n-1, m-1, grid, dp);        
    }

    int solve(int row, int col, int [][]grid, int [][]dp){

        if(dp[row][col] != -1) 
            return dp[row][col];
        
        
        if(row == 0 && col==0) 
            return dp[row][col] = grid[row][col];

        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;

        if(row > 0)
            up = grid[row][col] + solve(row -1, col, grid, dp);
        
        if(col >0)
            left = grid[row][col] + solve(row, col -1, grid, dp);


        return dp[row][col] = Math.min(up, left);
    }
}