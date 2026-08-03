import java.util.Arrays;

class Solution {

    int[][] dp;

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int x : nums)
            sum += x;

        // Impossible target
        if (Math.abs(target) > sum)
            return 0;

        dp = new int[nums.length][2 * sum + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(nums.length - 1, target, nums, sum);
    }

    int solve(int index, int target, int[] nums, int offset) {

        // Outside DP range
        if (target < -offset || target > offset)
            return 0;

        if (index == -1)
            return target == 0 ? 1 : 0;

        if (dp[index][target + offset] != -1)
            return dp[index][target + offset];

        int plus = solve(index - 1, target + nums[index], nums, offset);
        int minus = solve(index - 1, target - nums[index], nums, offset);

        return dp[index][target + offset] = plus + minus;
    }
}