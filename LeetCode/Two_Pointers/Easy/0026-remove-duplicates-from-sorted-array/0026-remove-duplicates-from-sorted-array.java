class Solution {
    public int removeDuplicates(int[] nums) {



        int n = nums.length;

        if(n == 0 || n == 1)
            return n;


        int ind = 0;

        for(int i = 1; i<n; i++){
            
            if(nums[i] != nums[ind]){
                nums[++ind] = nums[i];
            }
        }

        return ind+1;
    }
}