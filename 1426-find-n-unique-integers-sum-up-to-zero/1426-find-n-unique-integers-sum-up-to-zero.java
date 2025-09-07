class Solution {
    public int[] sumZero(int n) {
        int[] arr = new int[n];
        int val = 1;

        for (int i = 0; i < n; i += 2) {
            if (i + 1 < n) {
                arr[i] = val;
                arr[i + 1] = -val;
            } else {
                arr[i] = 0;
            }
            val++;
        }
        return arr;
    }
}