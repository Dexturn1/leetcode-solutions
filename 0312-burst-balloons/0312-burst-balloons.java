class Solution {
    public int maxCoins(int[] nums) {
        int m = nums.length;
        int []arr = new int[m+2];
        arr[0] = 1;
        arr[m+1] = 1;
        for(int i =0; i<m; i++){
            arr[i+1] = nums[i];
        }

        return solve(1, m, arr);
    }

    int solve(int i, int j, int[] arr){
        if(i > j) return 0;

        int max = Integer.MIN_VALUE; 
        for(int ind = i; ind <= j; ind++){
            int cost = arr[ind] * arr[i-1] * arr[j+1] + solve(i, ind-1, arr) + solve(ind+1, j, arr);
            max = Math.max(max, cost);
        }

        return max;
    
    }
}