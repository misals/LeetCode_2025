class Solution {
    public boolean canReach(int ind, int n, int[] arr, int[] dp) {
        if (ind < 0 || ind >= n) return false;

        if (arr[ind] == 0) return true;

        if (dp[ind] != -1) return dp[ind] == 1;

        dp[ind] = 0;

        boolean front = canReach(ind + arr[ind], n, arr, dp);
        boolean back = canReach(ind - arr[ind], n, arr, dp);

        if (front || back) {
            dp[ind] = 1;
            return true;
        }

        return false;
    }

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return canReach(start, n, arr, dp);

    }
}