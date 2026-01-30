class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int [][]dp = new int[n][n];
        for(int []row :dp) Arrays.fill(row, (int)1e9);
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            min = Math.min(min,solve(n-1, i, matrix, dp));
        }
        return min;
    }

    int solve(int row, int col, int[][]mat, int[][]dp){

        if(col < 0 || col>= mat[0].length) 
            return (int)1e9;

        if(dp[row][col] != (int)1e9)
            return dp[row][col];

        if(row == 0)
             return mat[row][col];

        int up = mat[row][col] + solve(row-1, col, mat, dp);
        int left =  mat[row][col] + solve(row-1, col-1, mat, dp);
        int right = mat[row][col] + solve(row-1, col+1, mat, dp);

        return dp[row][col] = Math.min(up, Math.min(left, right));        
    }
}