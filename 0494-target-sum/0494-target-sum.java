class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;

        for(int x: nums)totalSum +=x;

        if(Math.abs(target) > totalSum)return 0;

        if((target + totalSum) % 2 != 0)return 0;

        int requiredSum =(target+ totalSum)/2;

        return countSubset(nums, requiredSum);
        
    }

    int countSubset(int[]nums, int target){

        int n = nums.length;
        int [][]dp = new int[n][target+1];


        if(nums[0] == 0){
            dp[0][0] = 2;
        }else{
            dp[0][0] =1;

            if(nums[0] <= target){
                dp[0][nums[0]] = 1;
            }
        }

        for(int i = 1; i<n; i++){
            for(int sum = 0; sum<=target; sum++){

                int notTake = dp[i-1][sum];
                int take = 0;

                if(nums[i] <= sum){
                    take = dp[i-1][sum-nums[i]];
                }
                dp[i][sum] = take+notTake; 
            }

        }
        return dp[n-1][target];
    }
}