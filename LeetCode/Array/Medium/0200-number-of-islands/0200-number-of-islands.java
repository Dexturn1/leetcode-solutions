class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        int count = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if( grid[i][j] == '1' && !visited[i][j]){
                    bfs(i, j, grid, visited);
                    count++;
                }

            }
        }

        return count;
        
    }


    void bfs(int srow, int scol, char[][]grid, boolean[][]visited){

        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        visited[srow][scol] = true;
        q.offer(new int[]{srow, scol});

        int []delRow = {-1, 1, 0, 0};
        int []delCol = {0, 0, -1, 1};

        while(!q.isEmpty()){

            int []pair = q.poll();

            int row = pair[0];
            int col = pair[1];


            for(int i = 0; i<4; i++){
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow > -1 && newRow <n && 
                    newCol > -1 && newCol <m && 
                    !visited[newRow][newCol]&&
                    grid[newRow][newCol] == '1'
                ){
                    visited[newRow][newCol] = true;
                    q.offer(new int[]{newRow,newCol});
                }
            }

        }
    }
}