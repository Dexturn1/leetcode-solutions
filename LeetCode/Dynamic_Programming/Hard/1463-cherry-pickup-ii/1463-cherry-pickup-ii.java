class Solution {
    int [][][]dp;
    public int cherryPickup(int[][] grid) {

        int r = grid.length;
        int c = grid[0].length;

        dp = new int[r][c][c];

        for(int i[][]: dp){
            for(int[]row: i){
                Arrays.fill(row, -1);
            }
        }
        return solve(0, 0, c-1, c, r, grid);
        
    }

    int solve(int i , int j1, int j2, int col, int row,  int[][] grid){

        if(j1 < 0 || j2 < 0 || j1 >= col || j2 >= col){
            return (int)-1e8;
        }


        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        if(i == row-1){
            if( j1 == j2 )return grid[i][j1];
            else
                return grid[i][j1] + grid[i][j2];
        }



        // explore all cases
        int max = (int)-1e8;
        for(int dj1 = -1; dj1<=1; dj1++){
            for(int dj2 = -1; dj2<=1; dj2++){
                int value = 0;

                if(j1 == j2)
                    value = grid[i][j1];
                
                else{
                    value = grid[i][j1]+grid[i][j2];
                }

                value += solve(i+1, j1+dj1, j2+dj2, col, row, grid);
                max = Math.max(value, max); 
            }
        }

        return dp[i][j1][j2] = max;
    }
}