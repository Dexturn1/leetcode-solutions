class Solution {
    int [][]dp;

    public int lengthOfLIS(int arr[]) {
        
        dp = new int[arr.length][arr.length+1];

        for(int[] x: dp)Arrays.fill(x ,-1 );

        return solve(0, -1, arr);
    }

    
    int solve(int index, int prev, int[] arr){
        
        
        if(index == arr.length)return 0;


        if(dp[index][prev+1]!= -1)return dp[index][prev+1];


        int take = 0;
        if(prev == -1 || arr[index] > arr[prev] ){
            //take
             take = 1+ solve(index+1, index, arr);
        }
        
        
        // not take 
        int notTake = solve(index+1, prev, arr);
        
        
        
        return dp[index][prev+1]= Math.max(take, notTake);

    }
}
