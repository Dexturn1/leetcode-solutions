class Solution {
    public int findPeakElement(int[] nums) {

        int n = nums.length;

        // Edge Cases
        if(n == 1) return 0;
        if(nums[0] > nums[1] ) return 0;
        if(nums[n-1]>nums[n-2])return n -1;

        int low = 1;
        int high = n-2;

        while(low <= high){

            int mid = low + (high - low);
            
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]){
                return mid;
            }
            else if(nums[mid] > nums[mid-1]){
                /// Increasing slope -> peek on right
                low = mid +1;
            }else{
                //decreasing slope -> peak on left
                high = mid -1;
            }
        }    

        return -1;  
    }
}