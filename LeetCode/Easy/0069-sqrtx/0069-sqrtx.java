class Solution {
    public int mySqrt(int n) {
        int low = 0;
        int high = n;
        int ans = 0;
        
        while(low <= high){
        
            int mid = low + (high - low )/ 2;
            
             if (mid ==0 ||mid <= n / mid) {  // safe check
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
            
        }
        return ans; 
        
    }
}