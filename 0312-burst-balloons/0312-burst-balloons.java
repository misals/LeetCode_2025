class Solution {
    public int maxCoins(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
            int val = arr[i - 1] * arr[k] * arr[j + 1] + maxCoins(i, k - 1, arr, dp) + maxCoins(k + 1, j, arr, dp);
            ans = Math.max(ans, val);
        }
        return dp[i][j] = ans;
    }

    public int maxCoins(int[] nums) {
        int n = nums.length;

        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(dp[i], -1);
        }
        return maxCoins(1, n, arr, dp);
    }
}