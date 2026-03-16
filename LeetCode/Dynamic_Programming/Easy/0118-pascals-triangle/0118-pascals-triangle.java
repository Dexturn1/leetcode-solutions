class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 1; i<= numRows; i++){
            ans.add(generateRow(i));
        }

        return ans;

    }


    List<Integer> generateRow(int n){
        List<Integer> row = new ArrayList<>();
        long ans = 1;
        row.add(1);

        for(int col = 1; col < n; col++){
            ans = ans * (n-col);
            ans = ans / col;

            row.add((int)ans);
        }
        return row;
    }
}