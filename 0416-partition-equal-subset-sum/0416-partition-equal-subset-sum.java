class Solution {
    int [][]dp;
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for(int i: nums) sum+=i;

        if(sum%2 != 0)return false;

        int target = sum/2;

        dp = new int[nums.length][target+1];
        for(int i[]: dp)Arrays.fill(i,-1);

        return solve(nums.length-1, target, nums);
        
    }


    boolean solve(int index, int target, int[] nums){

        if(target == 0){
            return true;
        }

        if(index == 0){
            return target == nums[index];
        }

        if(dp[index][target] != -1)return dp[index][target] == 1;

        boolean pick = false;
        if(target >= nums[index]){
            pick = solve(index-1, target - nums[index], nums);
        }

        boolean notpick = solve(index-1, target, nums);


        dp[index][target] = pick||notpick? 1:0; 
        return  pick||notpick;
    }
}