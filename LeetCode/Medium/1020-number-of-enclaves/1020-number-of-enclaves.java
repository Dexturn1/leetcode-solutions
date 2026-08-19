class Solution {
    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean [][]visited = new boolean[n][m];


        for(int i = 0; i<n; i++){
            if(grid[i][0] == 1 && !visited[i][0]){
                dfs(i, 0, grid, visited);
            }

            if(grid[i][m-1] == 1 && !visited[i][m-1] ){
                dfs(i, m-1, grid, visited);
            }
        }

        for(int j = 0; j<m; j++){
            if(grid[0][j] == 1 && !visited[0][j]){
                dfs(0, j, grid, visited);
            }

            if(grid[n-1][j] == 1 && !visited[n-1][j]){
                dfs(n-1, j, grid, visited);
            }
        }



        int count = 0;

        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){

                if(grid[i][j] == 1 && !visited[i][j])
                    count++;
            }
        }

        return count;


    }



    public void dfs(int row, int col, int [][]grid, boolean[][]visited){
        
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = true;

        int []drow = {-1, 1, 0, 0};
        int []dcol = {0, 0, -1, 1};

        for(int i = 0; i<4; i++){

            int nRow = row + drow[i];
            int nCol = col + dcol[i];

            if(nRow > -1 && nRow < n &&
                nCol > -1 && nCol < m &&
                !visited[nRow][nCol] && 
                grid[nRow][nCol] == 1
                 )

                 dfs(nRow, nCol, grid, visited);

        }


    }


}