class Solution {
    int [][]dp;
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        dp = new int[n][n];
        for(int []row: dp){
            Arrays.fill(row, Integer.MAX_VALUE);  
        } 
        return solve(0, 0, triangle);     
    }


    int solve(int row,int col, List<List<Integer>> tri){

        if(row == tri.size()-1){
            return tri.get(row).get(col);
        }

        if(dp[row][col] != Integer.MAX_VALUE)return dp[row][col];

        int curr = tri.get(row).get(col);
        // move down 
        int down = curr + solve(row+1, col, tri);
        // move dig
        int dig = curr + solve(row+1, col+1, tri);
        

        return  dp [row][col]= Math.min(down ,dig);
    }
 }   
