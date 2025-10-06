class Solution {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};

    public boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        return true;
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, grid[0][0]});
        vis[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cell = pq.poll();

            for (int ind = 0; ind < 4; ind++) {
                int x = cell[0] + dx[ind];
                int y = cell[1] + dy[ind];
                int h = cell[2];

                if (!isValid(x, y, n, m) || vis[x][y]) {
                    continue;
                }

                int currHeight = grid[x][y];
                int totalHeight = Math.max(h, currHeight);

                if (x == n - 1 && y == m - 1) {
                    return totalHeight;
                }

                pq.offer(new int[]{x, y, totalHeight});
                vis[x][y] = true;
            }
        }
        return 0;
    }
}