class Solution {
    public boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        return true;
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] ans = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], -1);
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j =0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        while (!q.isEmpty()) {
            int sz = q.size();

            for (int i = 0; i < n; i++) {
                int[] arr = q.poll();
                int x = arr[0];
                int y = arr[1];

                for (int ind = 0; ind < 4; ind++) {
                    int a = x + dx[ind];
                    int b = y + dy[ind];

                    if (isValid(a, b, n, m) && ans[a][b] == -1) {
                        ans[a][b] = 1 + ans[x][y];
                        q.offer(new int[]{a, b});
                    }
                }

            }
        }
        return ans;
    }
}