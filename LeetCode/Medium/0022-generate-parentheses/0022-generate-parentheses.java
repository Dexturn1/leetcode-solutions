
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        StringBuilder curr = new StringBuilder(n);
        solve(curr, 0,0, n);
        return result;        
    }

    private void solve(StringBuilder curr,int open, int close, int n){
        // base condition
        if(curr.length() == 2*n){
                result.add(curr.toString());
                return;
        } 
        
        // Add '(' if we still have left parenthesis Avilable
        if(open < n){
            curr.append("(");
            solve(curr, open+1, close, n);
            curr.deleteCharAt(curr.length()-1);
        }

        // Add ')' if we still have right parenthesis Avilable
        if(close < open){
            curr.append(")");
            solve(curr,open,close+1,n);
            curr.deleteCharAt(curr.length()-1);
        }
    }

}