class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    public void backTrack(int index, int []arr, int target, List<Integer> ds, List<List<Integer>> ans){
        if(index == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(ds));
            }

            return;
        }
            

            // Pick
            if(arr[index] <= target){
                ds.add(arr[index]);
                backTrack(index, arr, target-arr[index], ds, ans);
                ds.remove(ds.size() -1);
            }
            // NonPick 
            backTrack(index+1, arr, target, ds, ans);
        }
}