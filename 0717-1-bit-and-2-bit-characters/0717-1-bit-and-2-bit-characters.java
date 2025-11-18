class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;

        while(i < n) {
            if (bits[i] == 1) {
                if (i == n - 2) {
                    return false;
                }
                i += 2;
            } else {
                i++;
            }
        }
        return true;
    }
}