class Solution {

    Integer[][] dp;

    public int lengthOfLIS(int[] nums) {

        dp = new Integer[nums.length][nums.length + 1];

        return solve(0, -1, nums);
    }

    int solve(int index, int prevIndex, int[] nums) {

        if(index == nums.length)
            return 0;

        if(dp[index][prevIndex + 1] != null)
            return dp[index][prevIndex + 1];

        int notTake = solve(index + 1, prevIndex, nums);

        int take = 0;
        if(prevIndex == -1 || nums[index] > nums[prevIndex]) {

            take = 1 + solve(index + 1, index, nums);
        }

        return dp[index][prevIndex + 1] =
                Math.max(take, notTake);
    }
}