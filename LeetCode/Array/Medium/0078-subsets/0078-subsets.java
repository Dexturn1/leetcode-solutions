class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), ans);
        return ans;
    }

    public void solve(int index, int []nums, List<Integer>ds, List<List<Integer>> ans){

        if(index == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        //pick
        ds.add(nums[index]);
        solve(index+1, nums, ds, ans);
        ds.remove(ds.size() - 1); 
        
        // non pick 
        solve(index+1, nums, ds, ans);
    }
}