class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n + 1][m + 1];

        char s[] = str1.toCharArray();
        char t[] = str2.toCharArray();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s[i - 1] == t[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = n;
        int j = m;

        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (s[i - 1] == t[j - 1]) {
                sb.append(s[i - 1]);
                i--;
                j--;
            } else if (dp[i][j - 1] > dp[i - 1][j]) {
                sb.append(t[j - 1]);
                j--;
            } else {
                sb.append(s[i - 1]);
                i--;
            }
        }

        while (i > 0) {
            sb.append(s[i - 1]);
            i--;
        }
        while (j > 0) {
            sb.append(t[j - 1]);
            j--;
        }

        return sb.reverse().toString();
    }
}