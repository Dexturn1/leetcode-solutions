class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int fz =-1;

        for(int i = 0;i<n; i++){
            if(nums[i] == 0){
                fz = i;
                break;
            }
        }

        if(fz == -1) return;
        
        for(int i = fz+1; i<n; i++){
            
            if(nums[i] != 0){
                nums[fz] = nums[i];
                fz++;
            }
        }

        for(int i=fz; i<n; i++){
            nums[i] = 0;
        }

    }
}