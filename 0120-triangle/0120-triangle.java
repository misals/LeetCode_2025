class Solution {
    public int minimumTotal(int i, int j, int n, List<List<Integer>> triangle, int[][] dp) {
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }

        if (dp[i][j] != -1) return dp[i][j];

        int sameIndex = triangle.get(i).get(j) + minimumTotal(i + 1, j, n, triangle, dp);
        int nextIndex = triangle.get(i).get(j) + minimumTotal(i + 1, j + 1, n, triangle, dp);

        return dp[i][j] = Math.min(sameIndex, nextIndex);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minimumTotal(0, 0, n, triangle, dp);
    }
}