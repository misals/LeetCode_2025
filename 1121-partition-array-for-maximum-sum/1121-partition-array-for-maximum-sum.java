class Solution {
    public int maxSumAfterPartitioning(int ind, int k, int n, int[] arr, int[] dp) {
        if (ind >= n) return 0;

        if (dp[ind] != -1) return dp[ind];

        int len = 0;
        int maxi = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;

        for (int i = ind; i < Math.min(n, ind + k); i++) {
            len++;
            maxi = Math.max(maxi, arr[i]);
            int val = (maxi * len) + maxSumAfterPartitioning(i + 1, k, n, arr, dp);

            ans = Math.max(ans, val);
        }
        return dp[ind] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return maxSumAfterPartitioning(0, k, n, arr, dp);
    }
}