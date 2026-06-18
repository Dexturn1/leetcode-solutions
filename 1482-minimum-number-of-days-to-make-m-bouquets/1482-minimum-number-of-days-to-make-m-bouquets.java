class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1;
        int high = getMax(bloomDay);
        int ans = -1;

        if( m * k > bloomDay.length) return -1;
        while(low <= high ){
            int mid = low + ( high - low) /2;

            if(canBloom(bloomDay, m, k, mid)){
                high = mid - 1;
                ans = mid;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    boolean canBloom(int []bloomsday, int m, int k, int mid){
        int count = 0;
        int bouquets = 0;
        for(int i = 0; i< bloomsday.length; i++){
            if(bloomsday[i] <= mid){
                count++;
            }else{
                count = 0;
            }

            if(count ==  k){
                bouquets++;
                count = 0;
                if(bouquets == m)return true;
            }
        } 
        return false;
    }
    
    int getMax(int []arr){
        int max = 0;
        for(int i: arr){
            max = Math.max(max, i);
        }
        return max;
    }
}