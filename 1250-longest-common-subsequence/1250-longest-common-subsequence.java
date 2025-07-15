class Solution {
    public int longestCommonSubsequence(int i, int j, char[] s, char[] t, int[][] dp) {
        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != -1) return dp[i][j];

        int firstWay = 0;
        if (s[i] == t[j]) {
            firstWay = 1 + longestCommonSubsequence(i - 1, j - 1, s, t, dp);
        }
        int secondWay = longestCommonSubsequence(i - 1, j, s, t, dp);
        int thirdWay = longestCommonSubsequence(i, j - 1, s ,t, dp);

        return dp[i][j] = Math.max(firstWay, Math.max(secondWay, thirdWay));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();

        int n = s.length;
        int m = t.length;

        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return longestCommonSubsequence(n - 1, m - 1, s, t, dp);
    }
}