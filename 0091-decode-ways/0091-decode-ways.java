class Solution {
    public int numDecodings(int ind, int n, String s, int[] dp) {
        if (ind >= n) return 1;

        if (s.charAt(ind) == '0') return 0;

        if (dp[ind] != -1) return dp[ind];

        int oneWay = numDecodings(ind + 1, n, s, dp);

        int twoWay = 0;
        if (ind + 1 < n) {
            int num = ((s.charAt(ind) - '0') * 10) + s.charAt(ind + 1) - '0';

            if (num >= 1 && num <= 26) {
                twoWay = numDecodings(ind + 2, n, s, dp);
            }
        }

        return dp[ind] = oneWay + twoWay;
    }

    public int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return numDecodings(0, n, s, dp);
    }
}