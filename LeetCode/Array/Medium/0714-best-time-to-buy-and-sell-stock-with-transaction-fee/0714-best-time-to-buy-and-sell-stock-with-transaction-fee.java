class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int [][]dp = new int[n][2];

        for(int []row: dp) 
            Arrays.fill(row, -1);

        return solve(0, 1, prices, fee, dp);
    }

    int solve(int index, int buy, int[] prices,int fee, int [][]dp){

        if(index == prices.length) return 0;

        if(dp[index][buy] != -1) return dp[index][buy];

        int profit = 0;
        if(buy == 1){
            int buying = -prices[index] + solve(index + 1, 0, prices, fee, dp);
            int notBuying = solve(index+1, 1, prices, fee, dp);
            profit = Math.max(buying, notBuying);
        }else{
            int sell = prices[index] - fee + solve(index + 1, 1, prices, fee, dp);
            int notSell = solve(index+1, 0, prices, fee, dp);
            profit = Math.max(sell, notSell);
        }

        return dp[index][buy] = profit;

    }
}