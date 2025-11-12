class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(),result);
        return result;
    }

    public void backtrack(int nums[], int index,List<Integer> curr, List<List<Integer>> result){
        result.add(new ArrayList(curr));

        for(int i = index; i<nums.length; i++){
            // skip duplicates 
            if(i>index && nums[i] == nums[i-1]) continue;

            curr.add(nums[i]);
            backtrack(nums, i+1, curr, result);
            curr.remove(curr.size()-1);
        }

    }
}