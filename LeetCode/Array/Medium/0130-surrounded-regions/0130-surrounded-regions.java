class Solution {

    public void dfs(int row, int col, char [][]board, boolean[][] visited){
        int n = board.length;
        int m = board[0].length;
        
        visited[row][col] = true;

        int []delRow = {-1, 0, 1, 0};
        int []delCol = {0, 1, 0, -1};
        for(int i=0; i<4; i++){
            int newRow = row + delRow[i];
            int newCol = col + delCol[i];

            if(newRow >= 0 && newRow <n && newCol >= 0 && newCol < m 
                && !visited[newRow][newCol] && board[newRow][newCol] == 'O'){
                    dfs(newRow, newCol, board, visited);
            }
            
        }

    }



    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean [][]visited = new boolean[n][m];

        for(int i = 0 ; i< m; i++){

            if(board[0][i] == 'O' && !visited[0][i]){
                dfs(0, i, board, visited);
            }

            if(board[n-1][i] == 'O' && !visited[n-1][i]){
                dfs(n-1, i, board, visited);
            }
        }


        for(int i =0; i < n; i++){

            if(board[i][0] == 'O' && !visited[i][0]){
                dfs(i,0, board, visited);
            }

            if(board[i][m-1] == 'O' && !visited[i][m-1]){
                dfs(i, m-1, board, visited);
            }
        }

        for(int i = 0; i< n; i++){
            for(int j = 0; j<m; j++){
                if(!visited[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
    }

}