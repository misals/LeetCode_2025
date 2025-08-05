class Solution {
    public int minDistance(int i, int j, char[] s, char[] t, int[][] dp) {
        if (i < 0) return j + 1;
        if (j < 0) return i + 1;

        if (dp[i][j] != -1) return dp[i][j];

        if (s[i] == t[j]) {
            return dp[i][j] = minDistance(i - 1, j - 1, s, t, dp);
        }

        return dp[i][j] = 1 + Math.min(minDistance(i, j - 1, s, t, dp), 
                Math.min(minDistance(i - 1, j, s, t, dp), minDistance(i - 1, j - 1, s, t, dp)));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        char[] s = word1.toCharArray();
        char[] t = word2.toCharArray();

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minDistance(n - 1, m - 1, s, t, dp);

    }
}