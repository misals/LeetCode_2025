class Solution {
    public boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        return true;
    }

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }

        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        int cnt = 0;

        int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
        int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            for (int ind = 0; ind < 8; ind++) {
                int x = cell[0] + dx[ind];
                int y = cell[1] + dy[ind];

                if (isValid(x, y, n, m) && grid[x][y] == cnt + 1) {
                    cnt++;
                    q.offer(new int[]{x, y});
                }
            }
        }

        return cnt == n * n - 1;
    }
}