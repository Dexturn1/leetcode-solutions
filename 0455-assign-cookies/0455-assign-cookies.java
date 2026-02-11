class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;

        while(g.length> i && s.length> j){
            if(g[i] <= s[j]){
                count++;
                i++;
                j++;
            }
            else{
                j++;
            }
        }

        return count;
    }
}