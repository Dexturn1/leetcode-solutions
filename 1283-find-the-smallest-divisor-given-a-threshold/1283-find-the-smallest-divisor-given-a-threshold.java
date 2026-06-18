class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = getMax(nums);
        int ans = -1;

        while(low<= high){
            int mid = low + (high - low )/2;

            if(isValid(nums, threshold, mid)){
                high = mid - 1;
                ans = mid;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean isValid(int []nums, int  threshold, int divisor){
        int sum = 0;
        for(int i = 0; i< nums.length; i++){
            sum += (nums[i] + divisor - 1)/divisor;
            if(sum > threshold) return false;
        }
        return true;
    }
    int getMax(int [] arr){
        int max = 0 ;
        for(int i : arr){
            max = Math.max(max, i);
        }
        return max;
    }
}