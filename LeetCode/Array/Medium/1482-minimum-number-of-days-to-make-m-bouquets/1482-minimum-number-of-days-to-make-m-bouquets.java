class Solution {

    public boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {
            if (bloom <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
        }
        return bouquets >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;

        // Impossible case
        if ((long) m * k > n) return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int answer = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, m, k, mid)) {
                answer = mid;      // possible, try smaller
                high = mid - 1;
            } else {
                low = mid + 1;     // need more days
            }
        }

        return answer;
    }
}
