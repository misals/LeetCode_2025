class Solution {
    public int mincostTickets(int ind, int n, int[] days, int[] costs, int[] dp) {
        if (ind >= n) {
            return 0;
        }

        if (dp[ind] != -1) {
            return dp[ind];
        }

        int oneDay = costs[0] + mincostTickets(ind + 1,  n, days, costs, dp);

        int i = ind;
        while (i < n && days[i] < days[ind] + 7) {
            i++;
        }

        int sevenDays = costs[1] + mincostTickets(i, n, days, costs, dp);

        while (i < n && days[i] < days[ind] + 30) {
            i++;
        }

        int thirtyDays = costs[2] + mincostTickets(i, n, days, costs, dp);

        return dp[ind] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
    }

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return mincostTickets(0, n, days, costs, dp);
    }
}