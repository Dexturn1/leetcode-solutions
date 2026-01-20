class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniColor = image[sr][sc]; 
        int [][]ans  = image;
        int [] delRow = {-1,0,1,0};
        int [] delCol = {0,1,0,-1};
        dfs(image, ans, delRow, delCol, sr, sc, iniColor, color);
        return ans;
    }

    public void dfs(int[][] image,int [][]ans,int[] delRow, int[]delCol,int sr, int sc, int iniColor, int color){
        ans[sr][sc] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++){
            int nrow = sr + delRow[i];
            int ncol = sc + delCol[i];

            if(nrow>=0 && nrow < n && ncol>=0 && ncol<m && image[nrow][ncol] == iniColor && ans[nrow][ncol] != color){
                dfs(image, ans, delRow, delCol, nrow, ncol, iniColor, color);
            }
            
        } 

    }



}