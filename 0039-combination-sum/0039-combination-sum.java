class Solution {
    public void combinationSum(int ind, int[] candidates, int target, List<Integer> list, Set<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(list));
        }
        if (ind < 0) {
            return;
        }

        combinationSum(ind - 1, candidates, target, list, ans);
        if (target >= candidates[ind]) {
            list.add(candidates[ind]);
            combinationSum(ind, candidates, target - candidates[ind], list, ans);
            list.remove(list.size() - 1);
        } 
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        combinationSum(n - 1, candidates, target, list, ans);

        List<List<Integer>> res = new ArrayList<>(ans);

        return res;
    }
}