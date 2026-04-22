class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] hash = new int[n];
        int[] dp = new int[n];

        int maxi = 0;
        int startIndex = 0;
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
                startIndex = i;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(nums[startIndex]);

        while (startIndex != hash[startIndex]) {
            startIndex = hash[startIndex];
            ans.add(nums[startIndex]);
        }

        return ans;
    }
}