class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        return solve(n-1,amount , coins);
    }

    public int solve(int index, int amount, int []coins){
        if(amount == 0)return 1;
         if (index == 0) {
            return amount % coins[0] == 0 ? 1 : 0;
        }
        
        int notPick = solve(index-1, amount, coins);
        int pick = 0;
            if(amount >= coins[index]){
                pick = solve(index, amount - coins[index], coins);
            }

        return pick + notPick;
    }
}