class Solution {
    public long minimumTotalDistance(int i, int j, int n, int m, List<Integer> robot, int[][] factory, long[][] dp) {
        if (i >= n) {
            return 0;
        }
        if (j >= m) {
            return (long)1e15;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        long res = minimumTotalDistance(i, j + 1, n, m, robot, factory, dp); 

        long cost = 0;
        int pos = factory[j][0];
        int limit = factory[j][1];

        for (int k = 0; k < limit && i + k < n; k++) {
            cost += Math.abs(robot.get(i + k) - pos);
            res = Math.min(res, cost + minimumTotalDistance(i + k + 1, j + 1, n, m, robot, factory, dp));
        }

        return dp[i][j] = res;
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        long[][] dp = new long[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minimumTotalDistance(0, 0, n, m, robot, factory, dp);
    }
}