class Solution {
    Boolean [][] dp;
    public boolean isMatch(String s, String p) {


        int n = s.length();
        int m = p.length();

        dp = new Boolean[n][m];

        return solve(n-1, m-1, s, p);
    }


    public boolean solve(int i, int j, String s1, String s2){


        if(i<0 && j<0)return true;
        if(j<0 && i>=0)return false;

        if(i < 0){
            while(j>=0){
                if(s2.charAt(j) != '*')return false;
                j--;
            }

            return true;
        }

        if(dp[i][j]!=null)return dp[i][j];

        if( (s1.charAt(i) == s2.charAt(j)) || s2.charAt(j) == '?' ){
            return dp[i][j] =solve(i-1, j-1, s1, s2);

        }else if(s2.charAt(j) == '*'){
            return dp[i][j] = solve(i-1, j, s1, s2) || solve(i, j-1, s1, s2);
        }

        return false;

    }

}