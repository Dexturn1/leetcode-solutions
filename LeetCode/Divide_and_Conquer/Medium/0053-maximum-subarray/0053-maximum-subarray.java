class Solution {
    public int maxSubArray(int[] nums) {

        int largetSum = Integer.MIN_VALUE;
        
        int sum = 0;
        for(int i = 0; i<nums.length; i++){

            sum = sum + nums[i];

            largetSum = Math.max(sum, largetSum);

            if(sum < 0){
                sum = 0;
            }

        }
        return largetSum;
    }
}