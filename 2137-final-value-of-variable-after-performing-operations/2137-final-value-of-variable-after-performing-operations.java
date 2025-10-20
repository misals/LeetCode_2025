class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int n = operations.length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String s = operations[i];

            if (s.charAt(0) == '-') {
                cnt--;
            } else if (s.charAt(0) == '+') {
                cnt++;
            } else if (s.charAt(2) == '-') {
                cnt--;
            } else {
                cnt++;
            }
        }
        return cnt;
    }
}