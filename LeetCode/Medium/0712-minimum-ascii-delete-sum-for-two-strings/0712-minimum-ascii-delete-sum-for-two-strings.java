class Solution {
    int dp[][];
    public int minimumDeleteSum(String s1, String s2) {

        int n = s1.length();
        int m = s2.length();

        dp = new int[n][m];

        for(int []row: dp)
            Arrays.fill(row, -1);

        return solve(n-1, m-1, s1, s2);
    }

    int solve(int i, int j, String s1, String s2){

        if(i < 0 ){
            int sum = 0;
            while(j>=0){
                sum += (int) s2.charAt(j);
                j--;
            }
            return sum;
        }

        if(j < 0 ){
             int sum = 0;
            while(i>=0){
                sum += (int) s1.charAt(i);
                i--;
            }
            return sum;
        }

        if( dp[i][j] != -1) 
            return dp[i][j];

        if(s1.charAt(i) ==  s2.charAt(j))
            return dp[i][j] = solve(i-1, j-1, s1, s2);
        
        else{

            return dp[i][j] =
                Math.min(
                    solve(i-1, j, s1, s2) + (int)s1.charAt(i),
                    solve(i, j-1, s1, s2) + (int)s2.charAt(j)
                ); 
        }
    }
}