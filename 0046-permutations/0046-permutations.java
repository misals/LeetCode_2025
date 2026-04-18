class Solution {
    public void swap(int[] nums, int i, int j) {
        int num = nums[i];
        nums[i] = nums[j];
        nums[j] = num;
    }

    public void permute(int ind, int n, int[] nums, List<Integer> temp, List<List<Integer>> ans) {
        if (ind == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = ind; i < n; i++) {
            swap(nums, ind, i);
            temp.add(nums[ind]);
            permute(ind + 1, n, nums, temp, ans);
            swap(nums, ind, i);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        permute(0, n, nums, temp, ans);

        return ans;
    }
}