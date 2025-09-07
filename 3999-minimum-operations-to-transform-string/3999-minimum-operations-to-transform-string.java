class Solution {
    public int minOperations(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (ch[i] != 'a') {
                mini = Math.min(mini, ch[i] - 'a');
            }
        }

        return mini == Integer.MAX_VALUE ? 0 : (26 - mini);
    }
}