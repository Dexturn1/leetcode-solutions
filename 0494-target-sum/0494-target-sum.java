class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums.length-1, target, nums);
    }

    int solve (int index, int target, int []nums){


        if(index == -1){
           return  target == 0 ? 1: 0;
        }
        

        int pos = solve(index-1, target + nums[index], nums);

        int neg = solve(index-1, target - nums[index], nums);
        

        return pos + neg;


    }
}