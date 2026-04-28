class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                list.add(grid[i][j]);
            }
        }

        Collections.sort(list);

        int cnt = 0;

        int sz = list.size();
        int mid = sz / 2;

        for (int i = 0; i < sz; i++) {
            if (i != mid) {
                int num = Math.abs(list.get(i) - list.get(mid));

                if (num % x == 0) {
                    cnt += num / x;
                } else {
                    return -1;
                }
            }
        }

        return cnt;
    }
}