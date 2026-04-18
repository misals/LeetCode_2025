class Solution {
    public int mirrorDistance(int n) {
        String s = Integer.toString(n);
        String reversed = new StringBuilder(s).reverse().toString();

        int m = Integer.parseInt(reversed);

        return Math.abs(n - m);
    }
}