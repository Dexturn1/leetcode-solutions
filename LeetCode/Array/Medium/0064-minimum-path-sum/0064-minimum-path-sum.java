class Solution {
    int dp[][];
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m];
        for(int[]i :dp){
            Arrays.fill(i,-1);
        }

        return solve(n-1, m-1, grid);
    }


    int solve(int row, int col, int [][]grid){


        if(row < 0 || col< 0)return Integer.MAX_VALUE;

        if(row == 0 && col == 0){
            return grid[row][col];
        }

        if(dp[row][col] != -1)return dp[row][col];
          int up = solve(row-1, col, grid);
          int left = solve(row, col-1, grid);

          if(up!=Integer.MAX_VALUE)
                up +=grid[row][col];
        
        if(left!=Integer.MAX_VALUE)
                left += grid[row][col];

        return dp[row][col] = Math.min(up, left);
    }
}