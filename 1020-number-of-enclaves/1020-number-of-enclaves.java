class Solution {

    void dfs(int row, int col, int[][] grid, boolean [][]visited){
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = true;

        int []delRow = {-1, 0, 1, 0};
        int []delCol = {0, 1, 0, -1};

        for(int i = 0; i<4; i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && 
                !visited[newRow][newCol] && grid[newRow][newCol] == 1){
                    dfs(newRow, newCol, grid, visited);
                }

        }

    }
    
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        boolean [][]visited = new boolean[n][m];

        for(int i = 0; i<m; i++){
            if(grid[0][i] == 1 && !visited[0][i]){
                dfs(0, i, grid, visited);
            }
            
            if(grid[n-1][i] == 1 && !visited[n-1][i]){
                dfs(n-1, i, grid, visited);
            }
        }

        for(int j = 0; j<n; j++){
            if(grid[j][0] == 1 && !visited[j][0]){
                dfs(j, 0, grid, visited);
            }

            if(grid[j][m-1] == 1 && !visited[j][m-1]){
                dfs(j, m-1, grid, visited);
            }
        }

        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    count++;
                }
            }
        }

        return count;    
    }
}