class Solution {

    int[] dp;

    public int rob(int[] nums) {

        int n = nums.length;

        if (n == 1) return nums[0];

        // Case 1: Rob houses from 0 to n-2
        dp = new int[n];
        Arrays.fill(dp, -1);


        int case1 = solve(n - 2, 0, nums);

        // Case 2: Rob houses from 1 to n-1
        dp = new int[n];
        Arrays.fill(dp, -1);
        
        int case2 = solve(n - 1, 1, nums);

        return Math.max(case1, case2);
    }

    int solve(int ind, int start, int[] nums) {

        if (ind < start)
            return 0;

        if (ind == start)
            return nums[start];

        if (dp[ind] != -1)
            return dp[ind];

        int pick = nums[ind] + solve(ind - 2, start, nums);
        int notPick = solve(ind - 1, start, nums);

        return dp[ind] = Math.max(pick, notPick);
    }
}