class Solution {
    public void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> temp) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
        }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i-1]) continue;
            if (arr[i] > target) break;

            temp.add(arr[i]);
            findCombinations(i + 1, arr, target - arr[i], ans, temp);
            temp.remove(temp.size() - 1);
        }
    }


    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        findCombinations(0, arr, target, ans, new ArrayList<>());

        return ans;
    }
}