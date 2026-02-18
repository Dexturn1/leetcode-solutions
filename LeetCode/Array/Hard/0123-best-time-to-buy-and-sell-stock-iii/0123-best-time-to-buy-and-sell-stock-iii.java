class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][]dp = new int[n][2][3];

        for(int [][]mat : dp) 
            for(int []row: mat) Arrays.fill(row, -1);
        return solve(0, 1, prices, 2, dp);
    }

    int solve(int index, int buy, int []prices, int cap, int dp[][][]){
        if(cap == 0 || index ==  prices.length) return 0;

        if (dp[index][buy][cap] != -1) return dp[index][buy][cap];

        int profit; 
        if(buy == 1){
            int buying = -prices[index] + solve(index+1, 0, prices, cap, dp);
            int notbuy = solve(index+1,1,prices,cap, dp);
            profit = Math.max(buying, notbuy);
        }else{
            int sell = prices[index] + solve(index+1, 1, prices, cap-1, dp);
            int notsell = solve(index+1, 0, prices, cap, dp);
            profit = Math.max(sell, notsell);
        }

        return dp[index][buy][cap] = profit;
    }

}
