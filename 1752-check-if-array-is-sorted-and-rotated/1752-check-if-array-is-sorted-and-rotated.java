class Solution {
    public boolean check(int[] nums) {
        int x = 0;
      for(int i = 0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]) 
                x++;
      }

      if(x == 0 ) return true;
      if(x >= 2) return false;

      return nums[nums.length-1] <= nums[0] ? true : false; 
    }
}