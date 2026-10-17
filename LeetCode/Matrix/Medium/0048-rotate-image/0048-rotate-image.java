class Solution {
    public void rotate(int[][] matrix) {

        for(int i = 0; i<matrix.length; i++){
            for(int j = i+1; j<matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        reverse(matrix);
        
    }

    void reverse(int[][] mat){
        int n = mat.length;

        for(int i = 0; i<n; i++){

            int left = 0;
            int right = n - 1;

            while(left < right){
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;

                left++;
                right--;
            }

        }   

    }
}