class Pair{
    int row; 
    int col;
    int tm;

    Pair(int row, int col, int tm){
        this.row = row;
        this.col = col;
        this.tm = tm;
    }

}

class Solution {
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new  LinkedList<>();

        int [][] visited = new int[n][m];
        int cntFresh = 0;


        // put all inintially rotten oranges into the queue
        for(int i = 0; i < n; i++){
            for(int j = 0; j<m; j++){

                if(grid[i][j] == 2 ){
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2; // mark as visited rotten
                }else{
                    visited[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }

        int tm = 0;
        // Direction vectors for 4 adjacent cells: up, right, down, left
        int [] drow = {-1, 0, +1, 0};
        int [] dcol = {0, 1, 0, -1};

        int cnt = 0;

        // Step 2: Multi-source BFS
        while(!q.isEmpty()){

            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;

            tm = Math.max(tm, t);
            q.remove();

            for(int i = 0; i < 4; i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];


                // check boundries, unvisted and fresh statues
                if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m 
                    && visited[nrow][ncol] == 0 
                    && grid[nrow][ncol] == 1){

                    q.add(new Pair(nrow, ncol, t + 1));
                    visited[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != cntFresh) return -1;
        return tm;
    }
}