class Solution {
    int [][][]dp;
    public int maxProfit(int[] prices) {

        int n = prices.length;

        dp = new int[n][2][2];

        for(int [][]arr: dp)
            for(int []row: arr) Arrays.fill(row, -1);       


        return solve(0, 1, 1, prices);
    }

    int solve(int index, int canBuy, int cooldown, int[] prices){

        if(index == prices.length)return 0;


        if(dp[index][canBuy][cooldown] != -1)
            return dp[index][canBuy][cooldown];

        int profit;
        if(canBuy == 1){
            int buy = Integer.MIN_VALUE;

            if(cooldown == 1)
                buy = -prices[index] + solve(index+1, 0, 1, prices);
            
            int skip = solve(index+1, 1, 1, prices);

            profit = Math.max(buy, skip);

        }else{
            int sell = prices[index] + solve(index+1, 1, 0, prices);
            int skip = solve(index+1, 0, 1, prices);
            profit = Math.max(sell, skip);
        }

        return dp[index][canBuy][cooldown] = profit;
    }

}