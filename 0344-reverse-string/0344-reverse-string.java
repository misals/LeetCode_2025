class Solution {
    public void reverseString(int i, int j, char[] s) {
        if (i >= j) {
            return;
        }
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
        reverseString(i + 1, j - 1, s);
    }

    public void reverseString(char[] s) {
        int low = 0;
        int high = s.length - 1;

        reverseString(low, high, s);
    }
}