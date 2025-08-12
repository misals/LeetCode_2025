class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfWays(int n, int base, int x, int[][] dp) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (base == 0) return 0;

        if (dp[n][base] != -1) return dp[n][base];

        int notPick = numberOfWays(n, base - 1, x, dp);
        int pick = 0;
        int val = (int) Math.pow(base, x);

        if (val <= n) {
            pick = numberOfWays(n - val, base - 1, x, dp);
        }

        return dp[n][base] = (pick + notPick) % MOD;
    }

    public int numberOfWays(int n, int x) {
        int maxNum = 1;

        for (int i = 1; i <= n; i++) {
            int val = (int) Math.pow(i, x);
            if (val <= n) {
                maxNum = i;
            } else {
                break;
            }
        }

        int[][] dp = new int[n + 1][maxNum + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return numberOfWays(n, maxNum, x, dp);
    }
}