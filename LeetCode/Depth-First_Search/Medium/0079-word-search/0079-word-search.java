class Solution {
    public boolean exist(char[][] board, String word) {

        for(int i = 0; i< board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(solve(board, i, j, 0, word.toCharArray())){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean solve(char[][] board, int row , int col, int ind, char[] word){

        // word found 
        if(ind == word.length){
            return true;
        }


        // Boundary check
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        // Already visited or charchater mistach
        if(board[row][col] == '*' || board[row][col] != word[ind]){
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '*';

        boolean found = solve(board, row-1, col, ind+1, word) || //top
                        solve(board, row+1, col, ind+1, word) || //botton
                        solve(board, row, col+1, ind+1, word) || //left
                        solve(board, row, col-1, ind+1, word ); // right

        board[row][col] = temp;

        return found;
    }
}