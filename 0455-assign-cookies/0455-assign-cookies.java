class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;

        int i = 0; 
        int j = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int cnt = 0;

        while (i < n && j < m) {
            if (s[j] >= g[i]) {
                cnt++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return cnt;
    }
}