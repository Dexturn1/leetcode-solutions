class Solution {
    public List<String> validStrings(int n) {
        return solve(new ArrayList<String>(), new StringBuilder(), false, n);
        
    }

    public List<String> solve(List<String> ans, StringBuilder string, boolean zeroLast ,int n){
        if(n == 0){
            ans.add(string.toString());
            return ans;
        }


        if(zeroLast == false){
            string.append('0');
            solve(ans, string, true, n-1);
            string.deleteCharAt(string.length() -1 );
        }

        string.append("1");
        solve(ans, string, false, n -1);
        string.deleteCharAt(string.length() -1 );

        return ans;
    }
}