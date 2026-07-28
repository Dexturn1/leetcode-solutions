class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char [][]board = new char[n][n];
        for(int i = 0; i<n; i++){
            Arrays.fill(board[i], '.');
        }

        int [] leftRow = new int[n];
        int [] upperDigonal = new int[2* n-1];
        int [] lowerDigonal = new int[2* n-1];

        backtrack(0, board, leftRow, upperDigonal, lowerDigonal, ans);
        return ans;

    }

    public void backtrack(int col, char[][]board, int[]leftRow , int[]upperDigonal, int[]lowerDigonal, List<List<String>> ans){

        if(col == board.length){
            ans.add(construct(board));
            return;
        }

        for(int row = 0; row < board.length; row++){

           if (leftRow[row] == 0 &&
                lowerDigonal[row + col] == 0 &&
                upperDigonal[board.length - 1 + col - row] == 0) {

                    board[row][col] = 'Q';
                    leftRow[row] = 1;
                    lowerDigonal[row + col] = 1;
                    upperDigonal[board.length - 1 + col - row] = 1;

                    backtrack(col + 1, board, leftRow, upperDigonal, lowerDigonal, ans);

                    board[row][col] = '.';
                    leftRow[row] = 0;
                    lowerDigonal[row + col] = 0;
                    upperDigonal[board.length - 1 + col - row] = 0;
                    
                    }
        }
    }
      public List<String> construct(char[][]board){

            List<String> temp = new ArrayList<>();
            for(char[] ch: board){
                temp.add(new String(ch));
            }
            return temp;
        }
}