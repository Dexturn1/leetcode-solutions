class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i: piles){
            max = Math.max(max,i);
        }
        int ans = max;
        int low =1;
        int high = max;
    
        while(low <= high){
            int mid = (low + high)/2;

            if(canEat(piles, mid, h)){
                ans = mid; 
                high = mid -1;
            }
            else{
                low = mid+1;
            }


        }
        return ans;
    }

    private boolean canEat(int[]piles, int speed, int h){
        long time = 0;
        for(int i: piles){
            time += (i + speed - 1)/speed;
            if (time > h) return false;
        }
        return true;
    }
}