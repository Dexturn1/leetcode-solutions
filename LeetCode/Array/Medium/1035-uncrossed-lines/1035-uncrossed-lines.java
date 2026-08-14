class Solution {
    int [][]dp;
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        dp = new int[n][m];

        for(int []row: dp)
            Arrays.fill(row, -1);


        return solve(n-1, m-1, nums1, nums2);        
        
    }

    int solve(int i, int j, int[] nums1, int[] nums2){

        if(i<0 || j<0)return 0;


        if(dp[i][j] != -1)
            return dp[i][j];

        if(nums1[i] == nums2[j]){
            return dp[i][j] = 1 + solve(i-1, j-1, nums1, nums2);
        }
        else{
            return dp[i][j] = Math.max(solve(i-1, j, nums1, nums2), solve(i, j-1, nums1, nums2));
        }
    }
}










