class Solution {

    public boolean checkValid(int n) {

        boolean hasChanged = false;

        while (n > 0) {
            int digit = n % 10;

            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }

            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasChanged = true;
            }

            n /= 10;
        }

        return hasChanged;
    }

    public int rotatedDigits(int n) {
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            int num = i;
            if (checkValid(num)) {
                cnt++;
            }
        }
        return cnt;
    }
}