class Solution {
    public void swapNumber(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void findPermute(int ind, int n, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if (ind == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = ind; i < n; i++) {
            swapNumber(nums, ind, i);
            temp.add(nums[ind]);
            findPermute(ind + 1, n, nums, temp, ans);
            swapNumber(nums, ind, i);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        findPermute(0, n, nums, temp, ans);

        return ans;
    }
}