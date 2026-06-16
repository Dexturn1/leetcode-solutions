class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;


        while(low< high){
            int mid = low + (high - low)/2;

            // make sure mid is even
            if(mid % 2 == 1)
                mid --;
            
            // check the pairs alignment
            if(nums[mid] == nums[mid+1]){
                // unique element is on the right
                low = mid + 2;
            }else{
                // unique elemet is on the left (including mid)
                high = mid;
            }
        }

        return nums[low];

    }

}