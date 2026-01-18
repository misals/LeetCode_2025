class Solution {
    public int minOperations(int[] nums, int[] target) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == target[i]) {
                continue;
            } else {
                mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
            }
        }

        return mp.size();
    }
}