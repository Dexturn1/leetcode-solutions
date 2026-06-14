class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int prefix = 1;
        int suffix = 1;


        for(int i = 0, j = n - 1; i < n; i++, j--){

            prefix *= nums[i];
            suffix *= nums[j];

            max = Math.max(max, Math.max(prefix, suffix));

            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;


        }

        return max;

    }
}