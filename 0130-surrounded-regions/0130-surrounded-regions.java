class Solution {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};

    public boolean isValid (int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        return true;
    }

    public void dfs(int i, int j, int n, int m, char[][] board, boolean[][] vis) {
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }
        vis[i][j] = true;

        for (int ind = 0; ind < 4; ind++) {
            int x = i + dx[ind];
            int y = j + dy[ind];

            if (isValid(x, y, n, m) && !vis[x][y]) {
                dfs(x, y, n, m, board, vis);
            }
        }


    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            dfs(i, 0, n, m, board, vis);
            dfs(i, m - 1, n, m, board, vis);
        }

        for (int i = 0; i < m; i++) {
            dfs(0, i, n, m, board, vis);
            dfs(n - 1, i, n, m, board, vis);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}