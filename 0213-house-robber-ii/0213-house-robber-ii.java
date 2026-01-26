class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1)return nums[0];
        int []arr1 = new int[n-1];
        int []arr2 = new int[n-1];

        for(int i = 1; i<n; i++){
            arr1[i-1] = nums[i];
            arr2[i-1] = nums[i-1]; 
        }

        return Math.max(Houserob(arr1), Houserob(arr2));
        
    }

     public int Houserob(int[] nums) {
        int n = nums.length;
        int []dp = new int[n];

        int prev = nums[0];
        int prev2 = 0;

        for(int i =1; i<n; i++){
            int take = nums[i];
            if(i>1) take += prev2;

            int notTake = prev;
            int curr = Math.max(take, notTake);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}