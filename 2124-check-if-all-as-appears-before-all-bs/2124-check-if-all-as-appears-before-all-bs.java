class Solution {
    public boolean checkString(String s) {
        int n = s.length();

        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a' && flag) {
                return false;
            }

            if (s.charAt(i) == 'b') {
                flag = true;
            }
        }

        return true;
    }
}