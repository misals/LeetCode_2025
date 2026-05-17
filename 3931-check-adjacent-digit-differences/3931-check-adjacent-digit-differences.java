class Solution {
    public boolean isAdjacentDiffAtMostTwo(String s) {
        int n = s.length();

        for (int i = 1; i < n; i++) {
            char a = s.charAt(i - 1);
            char b = s.charAt(i);

            int diff = Math.abs((a - '0') - (b - '0'));

            if (diff > 2) {
                return false;
            }
        }
        return true;
    }
}