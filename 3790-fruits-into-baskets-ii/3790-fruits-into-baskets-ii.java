class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (fruits[i] <= baskets[j]) {
                    baskets[j] = 0;
                    cnt++;
                    break;
                }
            }
        }
        return n - cnt;
    }
}