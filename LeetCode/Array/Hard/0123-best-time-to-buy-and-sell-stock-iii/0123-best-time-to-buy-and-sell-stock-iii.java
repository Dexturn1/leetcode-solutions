class Solution {
    int dp[][][];
    public int maxProfit(int[] prices) {
        int n = prices.length;
        
        dp = new int[n][2][3];
        for(int [][]x: dp){
            for(int []y:x)Arrays.fill(y, -1);
        }
       return solve(0, 1, 2, prices);
    }

    int solve(int index, int canBuy, int cap, int[]prices){

        if(index == prices.length || cap == 0){
            return 0;
        }


        if(dp[index][canBuy][cap] != -1) return dp[index][canBuy][cap];
        
        int profit;
        if(canBuy == 1 && cap > 0){

            int buy = -prices[index] + solve(index+1, 0, cap, prices);
            int skip = solve(index+1, 1, cap, prices);
            profit = Math.max(buy, skip);

        }else{
            int sell = prices[index] + solve(index+1, 1, cap-1, prices);
            int skip = solve(index+1, 0, cap, prices);
            profit = Math.max(sell, skip);
        }
        return dp[index][canBuy][cap]=profit;
    }
}