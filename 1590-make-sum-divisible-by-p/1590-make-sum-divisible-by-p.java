class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long rem = 0;

        for (int i = 0; i < n; i++) {
            rem += nums[i];
        }

        rem = rem % p;

        if (rem == 0) return 0;

        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, -1);

        int curr = 0;
        int mini = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            curr = (curr + nums[i]) % p;
            int tar = (curr - (int)rem + p) % p;

            if (mp.containsKey(tar)) {
                mini = Math.min(mini, i - mp.get(tar));
            }

            mp.put(curr, i);
        }

        if (mini == n || mini == Integer.MAX_VALUE) {
            return -1;
        }

        return mini;
    }
}