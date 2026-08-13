class Solution {
    int[] dp;

    public int jump(int[] nums) {
        int n = nums.length;

        dp = new int[n];
        Arrays.fill(dp, -1);

        return fun(nums, 0);
    }

    int fun(int[] nums, int index) {

        if (index >= nums.length - 1)
            return 0;

        if (dp[index] != -1)
            return dp[index];

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= nums[index]; i++) {

            int next = fun(nums, index + i);

            if (next != Integer.MAX_VALUE) {
                min = Math.min(min, next + 1);
            }
        }

        return dp[index] = min;
    }
}