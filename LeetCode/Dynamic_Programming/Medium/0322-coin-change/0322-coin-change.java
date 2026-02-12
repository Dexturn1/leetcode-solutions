class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][]dp = new int[n][amount+1];
         for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = solve(n-1, coins, amount, dp);
        return ans >= (int)1e9? -1 : ans;
    }
    int solve(int index, int[]coins, int amount, int dp[][]){

        if(index == 0){
            if(amount % coins[0] == 0) return amount/coins[index];
            else
                return (int)1e9;
        }

        if(dp[index][amount] !=-1 )return dp[index][amount];

        int notPick = 0 + solve(index-1, coins, amount, dp);

        int pick = Integer.MAX_VALUE;
        if(coins[index]<=amount){
            pick = 1 + solve(index, coins, amount - coins[index], dp);
        } 
        return dp[index][amount] =Math.min(pick, notPick);
    }
}