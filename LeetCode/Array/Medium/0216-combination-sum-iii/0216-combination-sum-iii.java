class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(1, k, n, ans, new ArrayList<>());
        return ans;
    }

     public void solve(int ind, int k, int sum, List<List<Integer>> ans , List<Integer> ds){

        if(ds.size() == k && sum == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i = ind; i< 10; i++){
            if(i > sum)break;

            ds.add(i);
            solve(i+1, k ,sum-i, ans, ds);
            ds.remove(ds.size()-1);
        }

    }

}