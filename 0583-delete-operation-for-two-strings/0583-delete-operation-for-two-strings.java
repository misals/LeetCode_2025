class Solution {
    public int minDistance(int i, int j, char[] s, char[] t, int[][] dp) {
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s[i] == t[j]) {
            return dp[i][j] = 1 + minDistance(i - 1, j - 1, s, t, dp);
        }

        return dp[i][j] = Math.max(minDistance(i - 1, j, s, t, dp), minDistance(i, j - 1, s, t, dp));


    }

    public int minDistance(String word1, String word2) {
        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return (n + m) - (2 * minDistance(n - 1, m - 1, s, t, dp));
    }
}