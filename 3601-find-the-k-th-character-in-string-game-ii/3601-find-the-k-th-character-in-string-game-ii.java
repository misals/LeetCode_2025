class Solution {
    public char kthCharacter(long k, int[] operations) {
        long length = 1;
        int lastUsefulIndex = 0;
        int n = operations.length;

        for (int i = 0; i < n; i++) {
            length *= 2;
            if (length >= k) {
                lastUsefulIndex = i;
                break;
            }
        }

        int shiftCount = 0;

        for (int i = lastUsefulIndex; i >= 0; i--) {
            length /= 2;

            if (k > length) {
                k -= length;

                if (operations[i] == 1) {
                    shiftCount++;
                }
            }
        }

        return (char)('a' + (shiftCount % 26));
    }
}