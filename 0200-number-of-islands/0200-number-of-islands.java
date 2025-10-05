class Solution {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};

    public boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        } 
        return true;
    }

    public void dfs(int i, int j, int n, int m, char[][] grid) {
        grid[i][j] = '0';

        for (int ind = 0 ; ind < 4; ind++) {
            int x = i + dx[ind];
            int y = j + dy[ind];

            if (isValid(x, y, n, m) && grid[x][y] == '1') {
                dfs(x, y, n, m, grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, n, m, grid);
                }
            }
        }

        return ans;
    }
}