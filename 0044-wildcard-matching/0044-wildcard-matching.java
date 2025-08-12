class Solution {
    public int isMatch(int i, int j, char[] s, char[] t, int[][] dp) {
        if (i == 0 && j == 0) return 1;
        if (j == 0 && i > 0) return 0;
        if (i == 0 && j > 0) {
            for (int ind = 1; ind <= j; ind++) {
                if (t[ind - 1] != '*') return 0;
            }
            return 1;
        }

        if (dp[i][j] != -1) return dp[i][j];

        if (s[i - 1] == t[j - 1] || t[j - 1] == '?') {
            return dp[i][j] = isMatch(i - 1, j - 1, s, t, dp);
        }

        if (t[j - 1] == '*') {
            return dp[i][j] = isMatch(i, j - 1, s, t, dp) | isMatch(i - 1, j, s, t, dp);
        }

        return dp[i][j] = 0;
    }

    public boolean isMatch(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();

        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return isMatch(n, m, s, t, dp) == 1;
    }
}
