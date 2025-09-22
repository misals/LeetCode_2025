class Solution {
    public int maxFrequencyElements(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }

        int maxi = 0;
        int cnt = 0;

        for (int num : mp.values()) {
            maxi = Math.max(maxi, num);
        }
        for (int num : mp.values()) {
            if (num == maxi) {
                cnt++;
            }
        }
    
        return cnt * maxi;
    }
}