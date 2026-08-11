class Solution {
    Boolean [][]dp;
    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        dp = new Boolean[n][m];

        return solve(n-1, m-1, s, p);
    }

    boolean solve(int i, int j, String s, String p){
        if(j<0)return i<0;

        if(i<0){
            while(j>=0){
                if(p.charAt(j) !='*')
                    return false;
                j--;
            }
            return true;
        }
    
        if(dp[i][j] != null)return dp[i][j];

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
           return dp[i][j]= solve(i-1, j-1, s, p);
        }else if(p.charAt(j) == '*'){
            boolean take = solve(i-1, j, s, p);
            boolean notPick = solve(i, j-1, s, p);
            return dp[i][j] = take||notPick;
        }else{
            return false;
        }
        
    }
}