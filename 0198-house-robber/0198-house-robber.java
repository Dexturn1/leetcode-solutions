class Solution {
    int dp[]; 
    public int rob(int[] nums) {

        dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return getMax(nums.length-1, nums);
    }

    public int getMax(int index, int[]nums){

        if(index == 0)return nums[index];
        if(index < 0)return 0;

        if(dp[index] != -1)return dp[index];

        int pick = nums[index]+ getMax(index-2, nums);
        int notPick = getMax(index-1, nums);

        return dp[index]= Math.max(pick, notPick);
    }
}