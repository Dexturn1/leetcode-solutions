class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i: nums) sum+= i;

        if( sum % 2 != 0) return false;

        int [][]dp = new int[n][sum/2+1];
        for(int []row : dp) Arrays.fill(row, -1); 

        return solve(n-1, sum/2,  nums,  dp);
    }
    boolean solve(int index, int target, int[]arr, int[][]dp){

        if(target == 0 ) return true;
        if(index < 0 || target < 0) return false;

        if (dp[index][target] != -1)
            return dp[index][target] == 1;
        
        boolean notTake = solve(index -1, target, arr, dp);
        boolean take = false;
        take = solve(index-1, target - arr[index], arr, dp);

        dp[index][target] = (take || notTake) ? 1 : 0;
        return take||notTake;
    }
}