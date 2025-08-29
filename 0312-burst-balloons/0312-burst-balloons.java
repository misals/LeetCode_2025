class Solution {
    public int maxCoins(int[] arr) {
        int n = arr.length;

        int[] nums = new int[n + 2];
        nums[0] = 1;
        nums[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            nums[i + 1] = arr[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) continue;

                int maxi = 0;
                for (int k = i; k <= j; k++) {
                    int val = nums[i - 1] * nums[k] * nums[j + 1] + dp[i][k - 1] + dp[k + 1][j];
                    maxi = Math.max(maxi, val);
                }
                dp[i][j] = maxi;
            }
        }

        return dp[1][n];
    }
}