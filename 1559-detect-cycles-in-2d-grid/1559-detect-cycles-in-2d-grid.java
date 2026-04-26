class Solution {
    public int dx[] = {0, -1, 0, 1};
    public int dy[] = {-1, 0, 1, 0};

    public boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        return true;
    }

    public boolean dfs(int i, int j, int px, int py, int n, int m, char[][] grid, int[][] vis) {
        vis[i][j] = 1;

        for (int dir = 0; dir < 4; dir++) {
            int x = i + dx[dir];
            int y = j + dy[dir];

            if (!isValid(x, y, n, m)) continue;

            if (grid[i][j] != grid[x][y]) continue;

            if (vis[x][y] == 1 && !(px == x && py == y)) return true;

            if (vis[x][y] == 0) {
                if (dfs(x, y, i, j, n, m, grid, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0) {
                    if (dfs(i, j, -1, -1, n, m, grid, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}