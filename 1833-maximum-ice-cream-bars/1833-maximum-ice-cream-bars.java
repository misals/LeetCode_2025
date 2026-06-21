class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        int sum = 0;
        int cnt = 0;

        Arrays.sort(costs);

        for (int i = 0; i < n; i++) {
            if (sum + costs[i] <= coins) {
                sum += costs[i];
                cnt++;
            } else {
                break;
            }
        }

        return cnt;
    }
}