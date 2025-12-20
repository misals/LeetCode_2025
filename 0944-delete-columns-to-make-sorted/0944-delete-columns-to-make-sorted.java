class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int cnt = 0;

        for (int j = 0; j < m; j++) {
            char ch = strs[0].charAt(j);
            for (int i = 1; i < n; i++) {
                if (strs[i].charAt(j) < ch) {
                    cnt++;
                    break;
                }
                if (strs[i].charAt(j) > ch) {
                    ch = strs[i].charAt(j);
                }
            }
        }
        return cnt;
    }
}