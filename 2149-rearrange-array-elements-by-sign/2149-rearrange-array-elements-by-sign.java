class Solution {
    public int[] rearrangeArray(int[] nums) {
        int []ans = new int[nums.length];

        int i =0;
        int j =1;

        for(int num: nums){
            if(num<0){
                ans[j] = num;
                j = j+2;
            }else{
                ans[i] = num;
                i = i+2;
            }  
        }
        return ans;
    }
}