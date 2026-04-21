class Solution {
    public int numDistinct(int i, int j, char[] s, char[] t, int[][] dp) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s[i] == t[j]) {
            return dp[i][j] = numDistinct(i - 1, j - 1, s, t, dp) + numDistinct(i - 1, j, s, t, dp);
        }

        return dp[i][j] = numDistinct(i - 1, j, s, t, dp);
    }

    public int numDistinct(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return numDistinct(n - 1, m - 1, s, t, dp);
    }
}