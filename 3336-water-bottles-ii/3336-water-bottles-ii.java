class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;

        while (numBottles >= numExchange) {
            int cnt = 0;

            while (numBottles >= numExchange) {
                cnt++;
                numBottles -= numExchange;
                numExchange++;
            }
            ans += cnt;
            numBottles += cnt;
        }
        return ans;
    }
}