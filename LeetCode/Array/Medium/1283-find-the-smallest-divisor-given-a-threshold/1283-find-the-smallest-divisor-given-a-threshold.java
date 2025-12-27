class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for(int i: nums){
            high = Math.max(high,i);
        }

        int ans = 1;
        while(low <= high){
            int mid =(low+high)/2;
            if(underthreshold(nums,threshold, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean underthreshold(int[]arr, int threshold, int mid){
        int sum = 0;

        for(int i: arr){
            sum += (i + mid - 1) / mid;

            if(sum>threshold){
                return false;
            }
        }
        return true;
    }
}