class Solution {
    public int[] rearrangeArray(int[] nums) {
       List<Integer> pos = new ArrayList<>();
       List<Integer> neg = new ArrayList<>();
       List<Integer> ans = new ArrayList<>();

       for(int i = 0; i<nums.length; i++){
        if(nums[i] < 0){
            neg.add(nums[i]);
        }else{
            pos.add(nums[i]);
        }   
       }

       int i =0;
       int j =0;
       while(ans.size() < nums.length){
        ans.add(pos.get(i++));
        ans.add(neg.get(j++));
       }

 int[] result = new int[ans.size()];

        for(int k = 0; k < ans.size(); k++){
            result[k] = ans.get(k);
        }

        return result;
    }
}