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

        int cnt1 = 0;
        int cnt2 = 0;

        int sz = list.size();
        int mid1 = sz / 2;
        int mid2 = (sz / 2) - 1;

        for (int i = 0; i < sz; i++) {
            if (i != mid1 && mid1 >= 0 && mid1 < sz) {
                int num = Math.abs(list.get(i) - list.get(mid1));

                if (num % x == 0) {
                    cnt1 += num / x;
                } else {
                    return -1;
                }
            }
        }

        for (int i = 0; i < sz; i++) {
            if (i != mid2 && mid2 >= 0 && mid2 < sz) {
                int num = Math.abs(list.get(i) - list.get(mid2));

                if (num % x == 0) {
                    cnt2 += num / x;
                } else {
                    return -1;
                }
            }
        }

        return Math.min(cnt1, cnt2);
    }
}