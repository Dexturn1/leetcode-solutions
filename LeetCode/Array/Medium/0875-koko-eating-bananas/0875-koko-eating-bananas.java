class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int i : piles){
            max= Math.max(max, i);
        }

        int low = 1;
        int high = max;
        int ans = 0;
        while(low<=high){
            int mid = low + (high - low) / 2;

            if(canEat(piles, mid, h)){
                ans = mid;
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canEat(int []piles, int speed, int h){
        long totalHours = 0;
        for(int bananas: piles){
            totalHours += (bananas + speed - 1)/ speed;
        }
        return totalHours <= h;
    }
}