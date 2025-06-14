class Solution {
    public int minMaxDifference(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        StringBuilder sb1 = new StringBuilder(String.valueOf(num));

        int n = sb.length();
        char ch = sb.charAt(0);

        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) != '9') {
                ch = sb.charAt(i);
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == ch) {
                sb.setCharAt(i, '9');
            }
        }
        ch = sb1.charAt(0);
        for (int i = 0; i < n; i++) {
            if (sb1.charAt(i) == ch) {
                sb1.setCharAt(i, '0');
            }
        }

        int val1 = Integer.parseInt(sb.toString());
        int val2 = Integer.parseInt(sb1.toString());

        return val1 - val2;
    }
}