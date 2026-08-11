class Solution {
    int [][]dp;
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        dp = new int[n][m];

        for(int []row: dp) 
            Arrays.fill(row, -1);

        return solve(n-1, m-1,  s,  t);
    }

    int solve(int i, int j, String s, String t){

        if(j<0)return 1;
        if(i<0)return 0;
        
        if(dp[i][j]!= -1 )return dp[i][j];

        int notPick = solve(i-1, j, s, t);

        int pick = 0;
        if(s.charAt(i) == t.charAt(j))  
           pick =  solve(i-1, j-1, s, t);

        return dp[i][j] = pick+ notPick;
    }

}