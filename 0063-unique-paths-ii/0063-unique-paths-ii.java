class Solution {
    int [][]dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int row = obstacleGrid.length-1; 
        int col = obstacleGrid[0].length-1;

        dp = new int[row+1][col+1];

        for(int[]i: dp){
            Arrays.fill(i, -1);
        }

        return solve(row, col , obstacleGrid);
    }
    
    int solve(int row, int col, int [][]arr){
        if(row < 0 || col < 0 || arr[row][col] == 1)
            return 0;

        if(dp[row][col]!= -1) return dp[row][col];

        if(row == 0 && col== 0)
            return 1;
        
        

        //move up
        int up = solve(row-1, col, arr);

        //move left
        int left = solve(row, col-1,arr);

        return dp[row][col] = up+left;
    }
}