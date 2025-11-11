class Solution {
    public int findZeros(String[] strs, int ind) {
        String s = strs[ind];
        int n = s.length();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                cnt++;
            }
        }
        return cnt;
    }

    public int findOnes(String[] strs, int ind) {
        String s = strs[ind];
        int n = s.length();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
        }
        return cnt;
    }

    public int findMaxForm(int ind, String[] strs, int m, int n, int[][][] dp) {
        if (ind < 0 || (m < 0 && n < 0)) {
            return 0;
        }

        if (dp[ind][m][n] != -1) return dp[ind][m][n];

        int notPick = findMaxForm(ind - 1, strs, m, n, dp);
        int pick = 0;

        int zeros = findZeros(strs, ind);
        int ones = findOnes(strs, ind);

        if (zeros <= m && ones <= n) {
            pick = 1 + findMaxForm(ind - 1, strs, m - zeros, n - ones, dp);
        }

        return dp[ind][m][n] = Math.max(pick, notPick);
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int sz = strs.length;

        int[][][] dp = new int[sz][m + 1][n + 1];

        for (int i = 0; i < sz; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return findMaxForm(sz - 1, strs, m, n, dp);
    }
}