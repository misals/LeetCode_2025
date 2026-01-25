class Solution {
    public int[] rotateList(List<Integer> list, int k) {
        int n = list.size();
        k %= n;

        int[] arr = new int[n];
        int ind = k;
        int i = 0;

        while (ind < n) {
            arr[i] = list.get(ind);
            i++;
            ind++;
        }

        ind = 0;

        while (ind < k) {
            arr[i] = list.get(ind);
            i++;
            ind++;
        }
        return arr;

    }

    public int[] rotateElements(int[] nums, int k) {
        int n = nums.length;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                list.add(nums[i]);
            }
        }

        if (list.size() == 0) return nums;

        int[] arr = rotateList(list, k);

        int ind = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                nums[i] = arr[ind];
                ind++;
            }
        }
        return nums;
    }
}