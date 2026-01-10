class Solution {
    public String largestEven(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for (int i = n - 1; i >= 0; i--) {
            int num = s.charAt(i) - '0';

            if (num % 2 == 0) {
                flag = true;
            }
            if (flag) {
                sb.insert(0, s.charAt(i));
            }
        }
        return sb.toString();
    }
}