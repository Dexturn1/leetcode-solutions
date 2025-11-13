class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] board = new int[n][n];
        solve(board, 0, n, result);
        return result;
    }

    public boolean isSafe(int board[][],int row, int col, int n){
        // check for the colums above the rows
        for(int i=0 ; i<row; i++){
            if(board[i][col] == 1){
                return false;
            }
        }

        // chekc if upper left digonal
        for(int i = row-1, j = col -1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        // check for upper right diagonal
        for(int i = row -1, j = col+1; i>=0 && j<n; i--, j++){
            if(board[i][j] == 1){
                return false;
            }
        }

        return true;

    }

    public void solve(int board[][], int row, int n, List<List<String>> result){
        if(row == n){
            result.add(construct(board,n));
            return;
        }

        for(int col = 0; col<n; col++){
            if(isSafe(board, row, col, n)){
                board[row][col] =1;
                solve(board, row+1, n, result);
                board[row][col]=0; //backtrack
            }            
        }
    }

    public List<String> construct(int board[][], int n){
        List<String> temp  = new ArrayList<>();
        for(int i = 0; i< n; i++){
            StringBuilder row  = new StringBuilder();
            for(int j = 0; j< n ; j++){
                row.append(board[i][j] == 1 ? 'Q': '.');
            }
            
            temp.add(row.toString());
        }

        return temp;
    }
}