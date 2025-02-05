class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        int lo = 0;
        int hi = n - 1;

        while (lo < hi) {
            boolean flag = false;
            if (s1.charAt(lo) != s2.charAt(lo)) {
                while (hi > lo) {
                    if (s1.charAt(hi) != s2.charAt(hi)) {
                        char temp = s1.charAt(lo);
                        s1 = s1.substring(0, lo) + s1.charAt(hi) + s1.substring(lo + 1);
                        s1 = s1.substring(0, hi) + temp + s1.substring(hi + 1);
                        flag = true;
                        break;
                    }
                    hi--;
                }
                if (flag) {
                    break;
                }
            }
            lo++;
        }
        return s1.equals(s2);
    }
}