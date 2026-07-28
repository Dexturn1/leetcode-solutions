class Solution {
    String[] map = {
    "",     // 0
    "",     // 1
    "abc",  // 2
    "def",  // 3
    "ghi",  // 4
    "jkl",  // 5
    "mno",  // 6
    "pqrs", // 7
    "tuv",  // 8
    "wxyz"  // 9
};
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        solve(digits, 0, ans, new StringBuilder());
        return ans;
    }

    public void solve(String digits, int index, List<String> ans, StringBuilder sb){
        if(index == digits.length()){
            ans.add(sb.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';
        for(char ch: map[digit].toCharArray()){
            sb.append(ch);
            solve(digits, index+1, ans, sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}