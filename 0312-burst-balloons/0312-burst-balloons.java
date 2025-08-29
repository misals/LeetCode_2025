class Solution {
    public int maxCoins(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int maxi = 0;
        for (int k = i; k <= j; k++) {
            int val = nums[i - 1] * nums[k] * nums[j + 1] + maxCoins(i, k - 1, nums, dp) + maxCoins(k + 1, j, nums, dp);
            maxi = Math.max(maxi, val);
        }
        return dp[i][j] = maxi;
    }

    public int maxCoins(int[] arr) {
        int n = arr.length;

        int[] nums = new int[n + 2];
        nums[0] = 1;
        nums[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            nums[i + 1] = arr[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(dp[i], -1);
        }

        return maxCoins(1, n, nums, dp);
    }
}