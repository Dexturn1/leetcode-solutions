class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;
        if(n == 1) return nums[0]; 
        int count = 0;
        int num =-1;


        for(int i=0; i<n; i++){
            if(count == 0){
                num = nums[i];
            }

            if(num == nums[i]){
                count++;
            }else{
                count --;
            }
        }

        return num;
        
    }
}