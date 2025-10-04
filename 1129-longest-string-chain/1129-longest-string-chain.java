class Solution {

    public boolean isValid(String a, String b) {
        int n = a.length();
        int m = b.length();

        char[] s = a.toCharArray();
        char[] t = b.toCharArray();

        if (n + 1 != m) {
            return false;
        }

        int cnt = 0;
        int i = 0;
        int j = 0;

        while (i < n && j < m) {
            if (s[i] == t[j]) {
                i++;
                j++;
            } else {
                cnt++;
                j++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }

    public int longestStrChain(int ind, int prev, int n, String[] words, int[][] dp) {
        if (ind < 0) {
            return 0;
        }

        if (dp[ind][prev] != -1) {
            return dp[ind][prev];
        }

        int notPick = longestStrChain(ind - 1, prev, n, words, dp);
        int pick = 0;

        if (prev == n || isValid(words[ind], words[prev])) {
            pick = 1 + longestStrChain(ind - 1, ind, n, words, dp);
        }

        return dp[ind][prev] = Math.max(notPick, pick);
    }

    public int longestStrChain(String[] words) {
        int n = words.length;
        int[][] dp = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        Arrays.sort(words, (a, b) -> Integer.compare(a.length(), b.length()));

        return longestStrChain(n - 1, n, n, words, dp);
    }
}