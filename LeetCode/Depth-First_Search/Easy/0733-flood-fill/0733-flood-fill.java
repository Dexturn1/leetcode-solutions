class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initicalColor = image[sr][sc];

        if(initicalColor == color){
            return image;
        }

        int [][]ans = new int[image.length][image[0].length];
        for(int i = 0 ; i < image.length; i++){
            for(int j = 0; j< image[0].length; j++){
                ans[i][j] = image[i][j];
            }
        }

        dfs(sr, sc , ans, image, color, initicalColor);
        return ans;
    }


    private void dfs(int r, int c, int [][]ans, int[][] image, int color, int initialColor){
        ans[r][c] = color;

        //  4 directional movement
        int [] delRow = {-1, 0, 1 , 0};
        int [] delCol = {0, 1, 0, -1 };

        for(int i = 0; i < 4; i++){
            int nRow = r + delRow[i];
            int nCol = c + delCol[i];

            //  check for boundries + same initial color+ not already painted
            if(nRow >= 0 && nRow < image.length && nCol >= 0 && nCol < image[0].length &&
                image[nRow][nCol] == initialColor && ans[nRow][nCol] != color){
                    dfs(nRow, nCol, ans, image, color, initialColor);
                }
 

        }

    }
}