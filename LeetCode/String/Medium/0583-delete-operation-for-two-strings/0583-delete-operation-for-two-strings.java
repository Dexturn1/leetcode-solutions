class Solution {
    int [][]dp;
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();


        dp = new int [n][m];
        for(int []row: dp)Arrays.fill(row, -1);

        return solve(n-1, m-1, word1, word2);
    }

    int solve(int i, int j, String s1, String s2){
        if(i < 0)return j+1;
        if(j< 0)return i+1;

        if(dp[i][j]!= -1)return dp[i][j];


        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = solve(i-1, j-1, s1, s2);
        }else{
           return dp[i][j] = Math.min(
            solve(i-1, j,s1, s2)+1 ,
            solve(i, j-1, s1, s2)+1
           );
        }

    }

}