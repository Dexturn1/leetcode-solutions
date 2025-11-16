class Solution {
    public void solveSudoku(char[][] board) {
      solve(board);  
    }

    public boolean solve(char[][] board){

        for(int row =0; row<9; row++){
            for(int col =0; col<9; col++){
                
                if(board[row][col] == '.'){ // empty cell found 

                    for(char digit = '1'; digit<='9'; digit++){

                        if(isValid(board, row , col , digit)){
                            board[row][col] = digit;    // plaing digit

                            if(solve(board))    // recure 
                                return true;

                            board[row][col] = '.'; // backtrack
                        }
                    }                    
                    return false;  // no digit fits → dead end
                }

            }
        }
        return true; // fully filled → solved
    }

    public boolean isValid(char[][] board, int row, int col, char ch){

        for(int i =0 ; i<9 ; i++){
            
            // check row 
            if(board[row][i] == ch ){
                return false;
            }

            //  check col
            if(board[i][col] == ch){
                return false;
            }

            // check for 3X3 box
            int boxRow = (row/3) * 3 + i/3;
            int boxCol = (col/3) * 3 + i%3;

            if(board[boxRow][boxCol] == ch){
                return false;
            }
        }

        return true;
    }
}