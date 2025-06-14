class Solution {
    public boolean isValid(int row, int col, char c, char[][] board) {
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == c) {
                return false;
            }
            if(board[row][i] == c) {
                return false;
            }
            if(board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) {
                return false;
            }
        }
        return true;
    }

    public boolean findValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(i, j, ch, board)) {
                            board[i][j] = ch;

                            if (findValidSudoku(board) == true) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }


                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        findValidSudoku(board);
    }
}