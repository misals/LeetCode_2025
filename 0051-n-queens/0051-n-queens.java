class Solution {
    public boolean isSafe(char[][] queens, int row, int col) {
        int n = row;
        int m = col;

        while (n >= 0 && m >= 0) {
            if (queens[n][m] == 'Q') {
                return false;
            }
            n--;
            m--;
        }

        n = row;
        m = col;

        while (n < queens.length && m >= 0) {
            if (queens[n][m] == 'Q') {
                return false;
            }
            n++;
            m--;
        }

        m = col;

        while (m >= 0) {
            if (queens[row][m] == 'Q') {
                return false;
            }
            m--;
        }
        return true;
    }

    public void solveNQueens(int col, int n, char[][] queens, List<List<String>> ans) {
        if (col == n) {
            List<String> temp = new ArrayList<>();

            for (char[] ch : queens) {
                temp.add(new String(ch));
            }
            ans.add(temp);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (isSafe(queens, row, col)) {
                queens[row][col] = 'Q';
                solveNQueens(col + 1, n, queens, ans);
                queens[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] queens = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(queens[i], '.');
        }

        List<List<String>> ans = new ArrayList<>();
        solveNQueens(0, n, queens, ans);

        return ans;

    }
}