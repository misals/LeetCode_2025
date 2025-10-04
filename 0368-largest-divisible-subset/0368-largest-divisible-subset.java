class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        int lastIndex = 0;

        int[] dp = new int[n];
        int[] hash = new int[n];

        Arrays.fill(dp, 1);
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            hash[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if (dp[i] > maxi) {
                maxi = dp[i];
                lastIndex = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[lastIndex]);

        while (lastIndex != hash[lastIndex]) {
            lastIndex = hash[lastIndex];
            list.add(nums[lastIndex]);
        }

        return list;
    }
}