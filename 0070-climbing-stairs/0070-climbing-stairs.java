class Solution {
    public int climbStairs(int n) {
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n,dp);
    }

    int solve(int n,int[]dp){
        if(n == 0){
            return 1;
        }


        if(dp[n]!= -1){
            return dp[n];
        }

        int two = 0;
        int one = 0;
        if(n>=2){
            two = solve(n -2,dp);
        }

        one = solve(n-1,dp);

        return dp[n] = one+two;
    }
}