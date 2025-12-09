class Solution {
    int MOD = 1000000007;
    public int specialTriplets(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int i = 2; i < n; i++) {
            rightMap.put(nums[i], rightMap.getOrDefault(nums[i], 0) + 1);
        }

        leftMap.put(nums[0], 1);

        long cnt = 0;
        int i = 1;

        while (i < n - 1) {
            int val = nums[i] * 2;

            if (leftMap.containsKey(val) && rightMap.containsKey(val)) {
                int n1 = leftMap.get(val);
                int n2 = rightMap.get(val);

                cnt = (cnt + ((long)n1 * (long)n2) % MOD) % MOD;
            }

            leftMap.put(nums[i], leftMap.getOrDefault(nums[i], 0) + 1);

            if (i + 1 < n) {
                rightMap.put(nums[i + 1], rightMap.getOrDefault(nums[i + 1], 0) - 1);

                if (rightMap.get(nums[i + 1]) == 0) {
                    rightMap.remove(nums[i + 1]);
                }
            }
            i++;
        }
        return (int)cnt;
    }
}