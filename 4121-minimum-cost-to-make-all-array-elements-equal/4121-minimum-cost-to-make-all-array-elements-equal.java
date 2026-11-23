class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        int cnt = 0;
        int val = nums[0];

        for (int i = 0; i < n; i++) {
            if (val == nums[i]) {
                cnt++;
            } else {
                val = nums[i];
                cnt = 1;
            }
            prefix[i] = cnt;
        }

        val = nums[n - 1];
        cnt = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == val) {
                cnt++;
            } else {
                val = nums[i];
                cnt = 1;
            }
            suffix[i] = cnt;
        }

        long ans = Long.MAX_VALUE;

        for (int i = 1; i < n - 1; i++) {
            int blockLength = prefix[i] + suffix[i] - 1;
            long cost = (long) nums[i] * (n - blockLength);
            ans = Math.min(ans, cost);
        }

        return ans;
    }
}