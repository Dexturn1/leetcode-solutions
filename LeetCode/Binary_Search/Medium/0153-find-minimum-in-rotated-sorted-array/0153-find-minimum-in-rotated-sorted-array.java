class Solution {
    public int findMin(int[] nums) {
        int sm = Integer.MAX_VALUE;
        int low = 0;
        int high = nums.length-1;

        while(low<= high){
             int mid = (low+high)/2;

             if(nums[low] <= nums[mid]){
                sm = Math.min(sm, nums[low]);
                low = mid+1;
             }else{
                sm  = Math.min(sm, nums[mid]);
                high = mid-1;
             }
        }

        return sm;
    }
}