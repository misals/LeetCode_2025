class Solution {
    public int minimumDeleteSum(int i, int j, char[] s, char[] t, int[][] dp) {
        if (i < 0 && j < 0) {
            return 0;
        }
        if (i < 0) {
            int sum = 0;
            for (int k = 0; k <= j; k++) {
                sum += t[k];
            }
            return sum;
        }
        if (j < 0) {
            int sum = 0;
            for (int k = 0; k <= i; k++) {
                sum += s[k];
            }
            return sum;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (s[i] == t[j]) {
            return dp[i][j] = minimumDeleteSum(i - 1, j - 1, s, t, dp);
        }

        int deleteS = s[i] + minimumDeleteSum(i - 1, j, s, t, dp);
        int deleteT = t[j] + minimumDeleteSum(i, j - 1, s, t, dp);

        return dp[i][j] = Math.min(deleteS, deleteT);
    }

    public int minimumDeleteSum(String s1, String s2) {
        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();

        int n = s.length;
        int m = t.length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minimumDeleteSum(n - 1, m - 1, s, t, dp);
    }
}