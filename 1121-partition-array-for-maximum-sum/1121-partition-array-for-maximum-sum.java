class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int len = 0;
            int maxi = Integer.MIN_VALUE;
            int ans = Integer.MIN_VALUE;

            for (int j = i; j < Math.min(n, i + k); j++) {
                len++;
                maxi = Math.max(maxi, arr[j]);
                int val = (maxi * len) + dp[j + 1];

                ans = Math.max(ans, val);
            }
            dp[i] = ans;
        }

        return dp[0];
    }
}