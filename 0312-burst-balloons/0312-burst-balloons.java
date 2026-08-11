class Solution {
    int dp[][];
    public int maxCoins(int[] nums) {

        int n = nums.length;
        int []arr= new int[n+2];
        arr[0] = 1;
        arr[n+1] = 1;

        for(int i = 0; i<n; i++)
            arr[i+1] = nums[i];

        dp = new int[n+2][n+2];
        for(int []row: dp)Arrays.fill(row, -1);

        return solve(1 , n, arr);
    }


    int solve(int i, int j, int[]arr){

        if(i>j)return 0;

        if(dp[i][j] != -1)return dp[i][j];

        int max = Integer.MIN_VALUE;
        for(int index = i; index<= j; index++){
            int point = arr[i-1] * arr[index] * arr[j+1] +
                        solve(i , index-1, arr)+
                        solve(index+1, j, arr);

            max = Math.max(point, max);
        }

        return dp[i][j] = max;

    }
}