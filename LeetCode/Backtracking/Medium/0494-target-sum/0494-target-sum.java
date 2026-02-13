class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return solve(n-1, nums,target);
    }

    public int solve(int index, int[]nums, int target){

        if (index == 0) {
    if (nums[0] == 0 && target == 0) return 2;  // +0 and -0
    if (nums[0] == target) return 1;
    if (-nums[0] == target) return 1;
    return 0;
}

        int positive = solve(index - 1, nums , target - nums[index]);
        int negitive = solve(index -1, nums, target + nums[index]);

        return positive + negitive;

    }
}