class Solution {
    public int climbStairs(int n) {
        int[] hash = new int[n+1];
        Arrays.fill(hash, -1);
        return solve(n, hash); 
    }

    public int solve(int n, int[] hash){
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }

        if(hash[n] !=-1){
            return hash[n];
        }

        return hash[n] = solve(n-1, hash) + solve(n-2,hash);
        
    }

}