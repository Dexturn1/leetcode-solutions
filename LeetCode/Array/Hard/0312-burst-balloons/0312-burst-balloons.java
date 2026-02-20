class Solution {
    public int maxCoins(int[] nums) {
        int m = nums.length;
        int []arr = new int[m+2];
        arr[0] = 1;
        arr[m+1] = 1;
        for(int i =0; i<m; i++){
            arr[i+1] = nums[i];
        }

        int [][]dp = new int[m+2][m+2];

        for(int []row: dp) Arrays.fill(row, -1); 

        return solve(1, m, arr,dp);
    }

    int solve(int i, int j, int[] arr, int dp[][]){
        if(i > j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int max = Integer.MIN_VALUE; 
        for(int ind = i; ind <= j; ind++){
            int cost = arr[ind] * arr[i-1] * arr[j+1] + solve(i, ind-1, arr, dp) + solve(ind+1, j, arr,dp);
            max = Math.max(max, cost);
        }

        return dp[i][j] = max;
    
    }
}