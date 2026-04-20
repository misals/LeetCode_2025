class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxi = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    maxi = Math.max(maxi, j - i);
                }
            }
        }
        return maxi;
    }
}