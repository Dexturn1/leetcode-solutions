class Solution {
    int dp[][];
    public int coinChange(int[] coins, int amount) {

        dp = new int[coins.length][amount+1];

        for(int []x: dp) Arrays.fill(x, -2);

        int ans = solve(coins.length-1, amount , coins);

        return ans == (int)1e9? -1: ans;
    }

    int solve(int index, int amount, int[] coins){

       if (index == 0) {
            if (amount % coins[0] == 0)
                return amount / coins[0];
            else
                return (int)1e9;
        }

        if(dp[index][amount]!= -2)
            return dp[index][amount];

        // pick
        int pick = (int)1e9;

        if(coins[index] <= amount ){
        pick = 1+ solve(index, amount - coins[index], coins);
        }
        //not pick
        int notPick = solve(index-1, amount, coins);

        return dp[index][amount] = Math.min(pick, notPick);

    }

}