import java.util.*;

class Solution {
    public static final int MOD = (int)1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);

        // Precompute powers of 2
        int[] pow = new int[n];
        pow[0] = 1;

        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int low = 0, high = n - 1;
        long ans = 0;

        while (low <= high) {
            if (nums[low] + nums[high] <= target) {
                ans = (ans + pow[high - low]) % MOD;
                low++;
            } else {
                high--;
            }
        }

        return (int) ans;
    }
}