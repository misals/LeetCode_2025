class Solution {
    public int longestCommonSubsequence(int i, int j, char[] s, char[] t, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s[i] == t[j]) {
            return dp[i][j] = 1 + longestCommonSubsequence(i - 1, j - 1, s, t, dp);
        }

        return dp[i][j] = Math.max(longestCommonSubsequence(i - 1, j, s, t, dp), 
                                    longestCommonSubsequence(i, j - 1, s, t, dp));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();

        int n = s.length;
        int m = t.length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return longestCommonSubsequence(n - 1, m - 1, s, t, dp);
    }
}