class Solution {
    public boolean isPalindrome(int start, int end, String s) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public int minCut(int ind, int n, String s, int[] dp) {
        if (ind == n) return 0;

        if (dp[ind] != -1) return dp[ind];

        int mini = Integer.MAX_VALUE;
        for (int i = ind; i < n; i++) {
            if (isPalindrome(ind, i, s)) {
                int val = 1 + minCut(i + 1, n, s, dp);
                mini = Math.min(mini, val);
            }
        }
        return dp[ind] = mini;
    }

    public int minCut(String s) {
        int n = s.length();

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return minCut(0, n, s, dp) - 1;
    }
}