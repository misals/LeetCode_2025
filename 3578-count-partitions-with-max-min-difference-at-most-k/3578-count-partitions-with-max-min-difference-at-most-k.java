
class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long mod = 1_000_000_007;

        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];

        dp[0] = 1;
        pref[0] = 1;

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();

        int L = 0;

        for (int i = 0; i < n; i++) {

            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i])
                minQ.pollLast();
            minQ.addLast(i);

            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i])
                maxQ.pollLast();
            maxQ.addLast(i);

            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                if (minQ.peekFirst() == L) minQ.pollFirst();
                if (maxQ.peekFirst() == L) maxQ.pollFirst();
                L++;
            }

            if (L == 0) {
                dp[i + 1] = pref[i] % mod;
            } else {
                dp[i + 1] = (pref[i] - pref[L - 1] + mod) % mod;
            }

            pref[i + 1] = (pref[i] + dp[i + 1]) % mod;
        }

        return (int) dp[n];
    }
}