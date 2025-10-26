class Solution {
    public long removeZeros(long n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        int sz = sb.length();

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < sz; i++) {
            if (sb.charAt(i) != '0') {
                ans.append(sb.charAt(i));
            }
        }

        return Long.parseLong(ans.toString());
    }
}