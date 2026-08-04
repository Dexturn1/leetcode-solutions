class Solution {
    public int change(int amount, int[] coins) {

        int n = coins.length;
        int [][]dp = new int[n][amount+1];


        //Base row initialization 
        for(int t = 0; t<= amount; t++){
            if(t % coins[0] == 0) dp[0][t] = 1;
        }

        for(int i = 1; i<n; i++){
            for(int target = 0; target<= amount ; target++){

                int pick = 0;
                if(coins[i] <= target){
                    pick = dp[i][target - coins[i]];
                }
                int notPick = dp[i-1][target];

                dp[i][target] = pick + notPick;
            }
        }

        return dp[n-1][amount];
        
    }
}