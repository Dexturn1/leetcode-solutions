class Solution {
    int dp[][];
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        dp = new int[n][m];

        for(int []row: dp)Arrays.fill(row ,-1);
        int lis = solve(n-1, m-1, word1, word2);

        return n - lis + m - lis;


    }


    int solve(int i, int j, String s1, String s2){

        if(i< 0 || j<0)return 0;


        if(dp[i][j] != -1)return dp[i][j];


        if( s1.charAt(i) == s2.charAt(j) ){
            return dp[i][j] = 1 + solve(i-1, j-1, s1, s2);
        }else{
            return dp[i][j] = Math.max(
                solve(i-1, j, s1, s2),
                solve(i, j-1, s1, s2)
            );
        }
    }
}