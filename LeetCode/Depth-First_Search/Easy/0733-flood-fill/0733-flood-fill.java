class Pixal{
    int row;
    int col;
    int preColor;
    Pixal(int row, int col, int color){
        this.row = row;
        this.col = col;
        this.preColor = color;
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int n = image.length;
        int m = image[0].length;


        boolean [][]visited = new boolean[n][m];


        int []delRow = {-1, 1, 0, 0};
        int []delCol = {0, 0, -1, 1};

        Queue<Pixal> queue = new LinkedList<>();
        visited[sr][sc] = true;
        queue.offer(new Pixal(sr, sc, image[sr][sc]));

        while(!queue.isEmpty()){
            int cRow = queue.peek().row;
            int cCol = queue.peek().col;
            int preColor = queue.peek().preColor;
            queue.poll();

            image[cRow][cCol] = color;


            for(int i = 0; i<delRow.length; i++){
                int nRow = cRow + delRow[i];
                int nCol = cCol + delCol[i];
               

                if(nCol>-1 && nCol <m && nRow >-1 && nRow<n && visited[nRow][nCol] == false && image[nRow][nCol] == preColor){
                    
                    visited[nRow][nCol] = true;
                    queue.offer(new Pixal(nRow, nCol, image[nRow][nCol]));
                }

            }

        }
        return image;
        
    }
}