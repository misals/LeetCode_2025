class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        int power = 0;
        int n = s.length();

        int value = 0;

        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '0') {
                count++;
            } else {
                if (power < 32) {
                    long num = 1l << power;

                    if (value + num <= k) {
                        value += num;
                        count++;
                    }
                }
            }
            power++;
        }

        return count;
    }
}