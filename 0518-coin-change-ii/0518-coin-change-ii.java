class Solution {

    int[][]dp;
    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount+1];
        for(int []row: dp)Arrays.fill(row, -1);
        return solve(coins.length-1, amount, coins);
    }


    int solve(int index, int target, int []coins){

        if(target == 0){
            return 1;
        }
        
        if(index == 0){
            if(target % coins[0] == 0 ){
                return 1;
            }
            return 0;
        }
        
        if(dp[index][target]!= -1)return dp[index][target];

        int pick = 0;
        if(coins[index]<= target){
            pick = solve(index, target - coins[index], coins);
        }

        int notPick = solve(index-1, target, coins);

        return dp[index][target] = pick + notPick;

    }
}