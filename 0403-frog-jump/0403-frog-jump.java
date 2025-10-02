class Solution {
    public boolean canCross(int ind, int step, int n, int[] stones, Map<Integer, Integer> mp, int[][] dp) {
        if (ind == n - 1) {
            return true;
        }
        
        if (dp[ind][step] != -1) {
            return dp[ind][step] == 1;
        }

        boolean ans = false;
        for (int i = step - 1; i <= step + 1; i++) {
            if (i > 0 && mp.get(stones[ind] + i) != null) {
                ans |= canCross(mp.get(stones[ind] + i), i, n, stones, mp, dp);
            }
        }
        dp[ind][step] = ans ? 1 : 0;
        return ans;
    }

    public boolean canCross(int[] stones) {
        int n = stones.length;
        Map<Integer,Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.put(stones[i], i);
        }

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return canCross(0, 0, n, stones, mp, dp);
    }
}