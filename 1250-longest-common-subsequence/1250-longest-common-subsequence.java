class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        char[] s = text1.toCharArray();
        char[] t = text2.toCharArray();

        int n = s.length;
        int m = t.length;

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                 if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }  
            }
        }

        return dp[n][m];
    }
}