class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char [][]board = new char[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(board[i], '.');
        }
        backtrack(0, board, ans);
        return ans;
    }

    public void backtrack(int col, char[][]board, List<List<String>>ans){

        if(col == board.length){
            ans.add(construct(board));
            return;
        }


        for(int row = 0; row < board.length; row++){
            if(isSafe(row, col , board)){
                board[row][col] = 'Q';
                backtrack(col+1, board, ans);
                board[row][col] = '.';
            }
        }
    }

    public List<String> construct(char [][] board){
        List<String> temp = new ArrayList<>();

        for(char[] row: board){
            temp.add(new String(row));
        }
        return temp;
    }

    private boolean isSafe(int row, int col, char[][]board){
        int r = row;
        int c = col;

        // check for the left
        while(c >= 0){
            if(board[r][c] == 'Q')
                return false;
            c--;
        }

        //check for the upper-left dig
        r = row;
        c = col;

        while( r >= 0 && c>= 0 ){

            if(board[r][c] == 'Q')
                return false;

            c--;
            r--;
        }

        // Check for the lower-left dig;
        r = row;
        c = col;

        while(c>= 0 && r< board.length){
            if(board[r][c] == 'Q')
                return false;
            c--;
            r++;
        }
        return true;
    }
}