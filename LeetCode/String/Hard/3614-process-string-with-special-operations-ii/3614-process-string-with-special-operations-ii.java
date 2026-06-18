class Solution {
    public char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n];
        
        // Step 1: build length array
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            if (i == 0) len[i] = 0;
            else len[i] = len[i - 1];
            
            if (c >= 'a' && c <= 'z') {
                len[i] += 1;
            } else if (c == '*') {
                if (len[i] > 0) len[i] -= 1;
            } else if (c == '#') {
                len[i] = Math.min(len[i] * 2, (long)1e15);
            } else if (c == '%') {
                // no length change
            }
        }
        
        // Step 2: check bounds
        if (k >= len[n - 1]) return '.';
        
        // Step 3: walk backwards
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            
            long prevLen = (i == 0) ? 0 : len[i - 1];
            
            if (c >= 'a' && c <= 'z') {
                if (k == prevLen) return c;
            } 
            else if (c == '*') {
                // undo delete → nothing to do
            } 
            else if (c == '#') {
                if (k >= prevLen) {
                    k -= prevLen;
                }
            } 
            else if (c == '%') {
                k = prevLen - 1 - k;
            }
        }
        
        return '.';
    }
}