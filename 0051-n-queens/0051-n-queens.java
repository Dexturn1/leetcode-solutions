class Solution {
    public List<List<String>> solveNQueens(int n) {

        char [][]board = new char[n][n];

        for(char []row: board){
            Arrays.fill(row, '.');
        }

        int[] leftRow = new int[n];
        int[] upperDig = new int[ 2*n -1];
        int[] lowerDig = new int[ 2*n - 1];

        List<List<String>> ans = new ArrayList<>();

        backtrack(0, board, leftRow, upperDig, lowerDig, ans);
        return ans;  
    }


    public void backtrack(int col, char[][]board,int []leftRow ,int[] upperDig, int[] lowerDig, List<List<String>> ans){
        if(col == board.length){
            ans.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++){

            // checking if pos is safe
            if( leftRow[row] == 0 && 
                upperDig[row+col] == 0 &&
                lowerDig[board.length - 1 + col - row] == 0){

                    board[row][col] = 'Q';

                    leftRow[row] = 1;
                    upperDig[row+col] = 1;
                    lowerDig[board.length - 1 + col - row] = 1; 

                    backtrack(col+1, board, leftRow, upperDig, lowerDig, ans);   

                    board[row][col] = '.';
                    leftRow[row] = 0;
                    upperDig[row+col] = 0;
                    lowerDig[board.length - 1 + col - row] = 0;                
            }
        }
    }

    public List<String> construct(char [][]board){
        List<String> temp = new ArrayList<>();
        for(char[] row: board){
            temp.add(new String(row));
        }
        return temp;
    }

}