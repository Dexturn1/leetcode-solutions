class Solution {
    int dp[][];
    public int minDistance(String s1, String s2) {
        int i = s1.length();
        int j = s2.length();

        dp = new int [i][j];
        for(int []row: dp)Arrays.fill(row, -1);

        return  solve(i-1, j-1, s1, s2);
    }

    int solve(int i, int j, String s1, String s2){

        // base case
        if(i <0)return j+1;
        if(j<0)return i+1;

        if(dp[i][j]!= -1)return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){

            return dp[i][j] = solve(i-1, j-1, s1, s2);
        }else{
            int replace = 1 + solve(i-1, j-1, s1, s2);
            int insert = 1 + solve(i, j-1, s1, s2);
            int delete = 1 + solve(i-1, j, s1, s2);

            return dp[i][j] = Math.min(replace, Math.min(insert, delete));   
        }

    }
}