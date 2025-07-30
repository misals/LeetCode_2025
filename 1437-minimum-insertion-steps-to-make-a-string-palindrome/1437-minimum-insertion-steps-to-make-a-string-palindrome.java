class Solution {
    public int minInsertions(int i, int j, char[] s, char[] t, int[][] dp) {
        if (i < 0) return 0;
        if (j < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        if (s[i] == t[j]) {
            return dp[i][j] = 1 + minInsertions(i - 1, j - 1, s, t, dp);
        }

        return dp[i][j] = Math.max(minInsertions(i - 1, j, s, t, dp), minInsertions(i , j - 1, s, t, dp));
    }

    public int minInsertions(String str) {
        int n = str.length();
        char[] s = str.toCharArray();
        char[] t = str.toCharArray();

        reverseString(t, n);

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return n - minInsertions(n - 1, n - 1, s, t, dp);
    }

    public void reverseString(char[] s, int n) {
        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            char ch = s[lo];
            s[lo] = s[hi];
            s[hi] = ch;
            lo++;
            hi--;
        }
    }
}