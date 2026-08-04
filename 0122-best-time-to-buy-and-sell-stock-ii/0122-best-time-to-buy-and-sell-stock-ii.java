class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = -1;
        }
        return solve(0, 1, prices, dp);
    }

    int solve(int index, int buy, int[] prices, int[][] dp) {
        if (index == prices.length) return 0;
        if (dp[index][buy] != -1) return dp[index][buy];

        int profit;
        if (buy == 1) {
            int take = -prices[index] + solve(index + 1, 0, prices, dp);
            int skip = solve(index + 1, 1, prices, dp);
            profit = Math.max(take, skip);
        } else {
            int sell = prices[index] + solve(index + 1, 1, prices, dp);
            int skip = solve(index + 1, 0, prices, dp);
            profit = Math.max(sell, skip);
        }

        return dp[index][buy] = profit;
    }
}
