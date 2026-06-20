class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        int m = restrictions.length;
        Arrays.sort(restrictions, (a, b) -> Integer.compare(a[0], b[0]));
        
        int[][] h = new int[m + 1][2];
        h[0][0] = 1;
        h[0][1] = 0;
        
        for (int i = 0; i < m; i++) {
            h[i + 1][0] = restrictions[i][0];
            h[i + 1][1] = restrictions[i][1];
        }
        
        for (int i = 1; i <= m; i++) {
            h[i][1] = Math.min(h[i][1], h[i - 1][1] + (h[i][0] - h[i - 1][0]));
        }
        
        for (int i = m - 1; i >= 0; i--) {
            h[i][1] = Math.min(h[i][1], h[i + 1][1] + (h[i + 1][0] - h[i][0]));
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int x1 = h[i][0], y1 = h[i][1];
            int x2 = h[i + 1][0], y2 = h[i + 1][1];
            ans = Math.max(ans, (y1 + y2 + (x2 - x1)) / 2);
        }
        
        ans = Math.max(ans, h[m][1] + (n - h[m][0]));
        
        return ans;
    }
}