class Solution {

    Boolean[][] dp;

    public boolean canCross(int[] stones) {
        dp = new Boolean[stones.length][stones.length];
        return solve(0, 1, stones);
    }

    private boolean solve(int index, int jump, int[] stones) {

        if (index == stones.length - 1)
            return true;

        if (dp[index][jump] != null)
            return dp[index][jump];

        for (int i = index + 1; i < stones.length; i++) {

            int distance = stones[i] - stones[index];

            if (distance < jump - 1)
                continue;

            if (distance > jump + 1)
                break;

            if (index == 0 && distance != 1)
                continue;

            if (solve(i, distance, stones))
                return dp[index][jump] = true;
        }

        return dp[index][jump] = false;
    }
}