class Solution {
    public int[] dx = {0, -1, 0, 1};
    public int[] dy = {-1, 0, 1, 0};

    public boolean isValid(int i, int j, int n, int m, int[][] ans) {
        if (i < 0 || i >= n || j < 0 || j >= m || ans[i][j] != 0) {
            return false;
        }
        return true;
    }

    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] ans = new int[n][m];

        Queue<List<Integer>> queue = new LinkedList<>();

        Arrays.sort(sources, (a, b) -> Integer.compare(b[2], a[2]));

        for (int[] src : sources) {
            ans[src[0]][src[1]] = src[2];
            List<Integer> temp = new ArrayList<>();
            temp.add(src[0]);
            temp.add(src[1]);
            queue.offer(temp);
        } 


        while (!queue.isEmpty()) {
            int sz = queue.size();

            for (int i = 0; i < sz; i++) {
                List<Integer> temp = queue.poll();

                int x = temp.get(0);
                int y = temp.get(1);

                for (int dir = 0; dir < 4; dir++) {
                    int a = x + dx[dir];
                    int b = y + dy[dir];

                    if (isValid(a, b, n, m, ans)) {
                        ans[a][b] = ans[x][y];
                        List<Integer> temp1 = new ArrayList<>();
                        temp1.add(a);
                        temp1.add(b);
                        queue.offer(temp1);
                    }
                }
            }
        }
        return ans;
    }
}