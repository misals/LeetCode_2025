class Solution {
    public int climbStairs(int ind, int n, int[] costs, int[] dp) {
        if (ind > n) {
            return Integer.MAX_VALUE;
        }
        if (ind == n) {
            return 0;
        }

        if (dp[ind] != -1) return dp[ind];

        int oneStep = costs[ind] + 1 + climbStairs(ind + 1, n, costs, dp);
        int twoStep = Integer.MAX_VALUE;
        if (ind + 2 <= n) {
            twoStep = costs[ind + 1] + 4 + climbStairs(ind + 2, n, costs, dp);
        }
        int threeSteps = Integer.MAX_VALUE;
        if (ind + 3 <= n) {
            threeSteps = costs[ind + 2] + 9 + climbStairs(ind + 3, n, costs, dp);
        }

        return dp[ind] = Math.min(oneStep, Math.min(twoStep, threeSteps));
    }

    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];

        Arrays.fill(dp, -1);
        
        return climbStairs(0, n, costs, dp);
    }
}