class Solution {
    public int[] bestTower(int[][] towers, int[] center, int radius) {
        int n = towers.length;
        int quality = Integer.MIN_VALUE;

        int x1 = center[0];
        int y1 = center[1];

        int idx = 0;
        int idy = 0;

        for (int i = 0; i < n; i++) {
            int x = towers[i][0];
            int y = towers[i][1];
            int qua = towers[i][2];

            int dist = Math.abs(x - x1) + Math.abs(y - y1);

            if (dist <= radius) {
                if (qua > quality) {
                    quality = qua;
                    idx = x; 
                    idy = y;
                } else if (qua == quality) {
                    if (x < idx || (x == idx && y < idy)) {
                        idx = x;
                        idy = y;
                    }
                }
            }
        }

        int[] arr1 = {-1, -1};
        int[] arr2 = {idx, idy};

        return quality == Integer.MIN_VALUE ? arr1 : arr2;
        
    }
}