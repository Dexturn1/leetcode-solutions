class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int n = bloomDay.length;

        if(n <(long) m*k ) return -1;

        int high = Integer.MIN_VALUE;
        int low = Integer.MAX_VALUE;

        for(int i: bloomDay){
            high = Math.max(i, high);
            low = Math.min(i, low);
        }
        int ans = high;
        while(low<= high){
            int mid = (low + high)/2;
            
            if( isPossible(bloomDay,m,k,mid)){
                ans = mid;
                high = mid -1;
            }else{
                low = mid+1;
            }
        } 

        return ans;
    }

    public boolean isPossible(int[] bloomDay, int m, int k, int mid){
        int count = 0;
        int bouquet = 0;
        for(int i: bloomDay){
            if( i <= mid)
                count++;
            else{
                count  = 0;
            }
            if(count == k){
                bouquet++;
                count = 0;

                if(bouquet>= m){
                    return true;
                }
            }
        }
    return false;
    }
}