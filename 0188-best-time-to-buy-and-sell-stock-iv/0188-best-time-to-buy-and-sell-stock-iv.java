class Solution {
    int [][][]dp;
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;

        dp = new int[n][2][k+1];

        for(int [][]x: dp)
            for(int []y: x)Arrays.fill(y, -1);        

        return solve(0, 1, k, prices);
    }

    int solve(int index,int canBuy, int k, int []prices){

        if(index == prices.length || k == 0)return 0;


        if(dp[index][canBuy][k] != -1)
            return dp[index][canBuy][k];

        int profit;
        if(canBuy == 1){
            int buy = -prices[index] + solve(index+1, 0, k, prices);
            int skip = solve(index+1, 1, k, prices);
            profit = Math.max(buy, skip);
        }else{
            int sell = prices[index] + solve(index+1, 1, k-1, prices);
            int skip = solve(index+1, 0, k, prices);
            profit = Math.max(sell, skip);
        }

        return dp[index][canBuy][k] = profit;
    }
}