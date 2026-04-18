class Solution {
    static final int n = 100005;
    static boolean[] sieve = new boolean[n];

    static {
        sieve[0] = sieve[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!sieve[i]) {
                for (int j = i * i; j < n; j += i) {
                    sieve[j] = true;
                }
            }
        }
    }

    public int minOperations(int[] nums) {
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (i % 2 != 0) {
                while (!sieve[num++]) {
                    cnt++;
                }
            } else {
                while (sieve[num++]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}