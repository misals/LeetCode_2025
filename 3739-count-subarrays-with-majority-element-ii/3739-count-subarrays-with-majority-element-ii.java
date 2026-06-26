class Solution {

    class Fenwick {
        long[] tree;

        Fenwick(int n) {
            tree = new long[n + 1];
        }

        void update(int index, long val) {
            while (index < tree.length) {
                tree[index] += val;
                index += index & -index;
            }
        }

        long query(int index) {
            long sum = 0;

            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        Fenwick tree = new Fenwick(2 * n + 2);
        int balance = n + 1;
        tree.update(balance, 1);

        long ans = 0;

        for (int num : nums) {
            if (num == target)
                balance++;
            else
                balance--;

            ans += tree.query(balance - 1);

            tree.update(balance, 1);
        }
        return ans;
    }
}