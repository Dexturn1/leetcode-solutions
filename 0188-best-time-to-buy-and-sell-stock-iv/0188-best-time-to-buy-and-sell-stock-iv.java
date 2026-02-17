class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int dp[][][] = new int[n][2][k+1];
        for(int [][]mat : dp)
            for(int row[]: mat)Arrays.fill(row, -1);

        return solve(0, 1, k, prices, dp);
    }
    
    int solve(int index, int buy, int k, int[] prices, int [][][]dp){
        if(k == 0 || index == prices.length) return 0;
        if(dp[index][buy][k] != -1) return dp[index][buy][k];

        int profit; 
        if(buy == 1){
            int buying = -prices[index] + solve(index+1, 0, k, prices, dp);
            int notbuy = solve(index+1, 1, k, prices, dp);
            profit = Math.max(buying, notbuy);
        }else{
            int selling = prices[index] + solve(index+1, 1, k-1, prices, dp);
            int notsell = solve(index+1, 0, k, prices,dp);
            profit = Math.max(selling, notsell);
        }      

        return  dp[index][buy][k] = profit;

    }
}