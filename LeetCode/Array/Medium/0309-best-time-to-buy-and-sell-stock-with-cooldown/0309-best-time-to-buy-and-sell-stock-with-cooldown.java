class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int [][][]dp = new int[n][2][2];

        for(int [][]mat: dp)
            for(int []row: mat) Arrays.fill(row, -1);

        return solve(0, 1, 1, prices,dp);
    }
    
    int solve(int index, int buy, int cooldown, int []prices, int [][][]dp){
        if(index == prices.length)return 0;

        if(dp[index][buy][cooldown] != -1) return dp[index][buy][cooldown];

        int profit; 

        if(buy==1){
            int buying = Integer.MIN_VALUE;

           if(cooldown == 1)
                buying = -prices[index] + solve(index + 1, 0, 1, prices, dp);

            int notbuy = solve(index+1, 1, 1, prices, dp);

            profit = Math.max(buying, notbuy);

        }else{
            int sell = prices[index] + solve(index+1, 1, 0, prices, dp );
            int notSell = solve(index+1, 0, 1, prices, dp);
            profit = Math.max( sell, notSell);
        }
        return dp[index][buy][cooldown] = profit;

    }

}