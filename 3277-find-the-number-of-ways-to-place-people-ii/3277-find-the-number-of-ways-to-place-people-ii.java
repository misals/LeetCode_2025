class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int ax = points[i][0];
                int ay = points[i][1];

                int bx = points[j][0];
                int by = points[j][1];

                if (ax > bx) continue;

                if (ay < by) continue;

                boolean flag = true;

                for (int k = 0; k < n; k++) {
                    if (i == k || j == k) {
                        continue;
                    }

                    int cx = points[k][0];
                    int cy = points[k][1];

                    if (cx >= ax && cx <= bx && cy <= ay && cy >= by) {
                        flag = false;
                        break;
                    }
                }

                if (flag) ans++;
            }
        }
        return ans;
    }
}