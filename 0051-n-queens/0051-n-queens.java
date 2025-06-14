class Solution {
    public void findAllWays(int col, int n, char[][] nQueens, List<List<String>> ans, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {
        if (col == n) {
            List<String> list = new ArrayList<>();
            for (char[] rowArray : nQueens) {
                list.add(new String(rowArray));
            }
            ans.add(list);
            return;
        }

        for (int row = 0; row < n; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[n - 1 + col - row] == 0) {
                nQueens[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n - 1 + col - row] = 1;
                findAllWays(col + 1, n, nQueens, ans, leftRow, upperDiagonal, lowerDiagonal);
                nQueens[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n - 1 + col - row] = 0;

            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] nQueens = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        } 

        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[n * 2 + 1];
        int[] lowerDiagonal = new int[n * 2 + 1];
 
        findAllWays(0, n, nQueens, ans, leftRow, upperDiagonal, lowerDiagonal);

        return ans;
    }
}