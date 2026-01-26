class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        List<List<Integer>> ans = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, Math.abs(arr[i] - arr[i - 1]));
        }

        for (int i = 1; i < n; i++) {
            if (minDiff == Math.abs(arr[i] - arr[i - 1])) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i - 1]);
                temp.add(arr[i]);

                ans.add(temp);
            }
        }
        return ans;
    }
}