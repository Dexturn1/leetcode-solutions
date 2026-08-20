class Solution {
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean [][]visited = new boolean[n][m];

        for(int i = 0; i<n; i++){
            if(board[i][0] == 'O' && !visited[i][0]){
                dfs(i, 0, board, visited);
            }
            if(board[i][m-1] == 'O' && !visited[i][m-1]){
                dfs(i, m-1, board, visited);
            } 
        }

        for(int j = 0 ; j<m; j++){
            if(board[0][j] == 'O'&& !visited[0][j]){
                dfs(0, j, board, visited);
            }
            if(board[n-1][j] == 'O'&&!visited[n-1][j]){
                dfs(n-1, j, board, visited);
            } 
        }

        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }

            }
        }



    }

    void dfs(int row, int col, char[][] board, boolean[][]visited ){

        visited[row][col] = true;


        int []dRow ={-1, 1, 0, 0};
        int []dCol = {0, 0, -1, 1};

        for(int i =0; i<4; i++){

            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if( nRow > -1 && nRow < board.length && 
                nCol > -1 && nCol < board[0].length && 
                board[nRow][nCol] == 'O' && 
                !visited[nRow][nCol]){
                 
                dfs(nRow, nCol, board, visited);
                }
        }

    }

}