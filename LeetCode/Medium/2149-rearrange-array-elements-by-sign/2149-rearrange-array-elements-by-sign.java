class Solution {
    public int[] rearrangeArray(int[] nums) {
        int pos = 0;
        int neg = 1;

        int []tmp = new int[nums.length];

        for(int num: nums){
            //  pos
            if(num >= 0){
                tmp[pos] = num;
                pos += 2;
            }else{
                tmp[neg] = num;
                neg += 2;
            }
        }
        return tmp;
    }
}