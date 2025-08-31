class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n = order.length;
        int m = friends.length;

        int[] dp = new int[n + 1];

        for (int i = 0; i < m; i++) {
            dp[friends[i]] = 1;
        }

        int[] ans = new int[m];
        int ind = 0;

        for (int i = 0; i < n; i++) {
            if (dp[order[i]] == 1) {
                ans[ind] = order[i];
                ind++;
            }
        }
        return ans;
    }
}