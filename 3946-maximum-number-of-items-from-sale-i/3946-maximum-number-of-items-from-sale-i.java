class Solution {
    int[][] dp = new int[1001][1501];

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;

        int cheapestItem = Integer.MAX_VALUE;
        int[] copies = new int[n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        for(int i = 0; i < n; i++){
            cheapestItem = Math.min(cheapestItem, items[i][1]);

            for(int j = 0; j < n; j++){
                if(i == j) continue;
                if(items[j][0] % items[i][0] == 0) copies[i]++;
            }
        }
        return helper(n, items, budget, cheapestItem, copies);  
    }

    int helper(int n, int[][] items, int budget, int cheapestItem, int[] copies){
        if(n == 0) return budget / cheapestItem;

        if(dp[n][budget] != -1) return dp[n][budget];

        int take = 0;
        if(items[n - 1][1] <= budget){
            take = 1 + copies[n - 1] + helper(n - 1, items, budget - items[n - 1][1], cheapestItem, copies);
        }
        int notTake = helper(n - 1, items, budget, cheapestItem, copies);

        return dp[n][budget] = Math.max(take, notTake);
    }
}