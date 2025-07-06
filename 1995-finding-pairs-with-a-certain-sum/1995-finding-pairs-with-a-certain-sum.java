class FindSumPairs {
    Map<Integer, Integer> mp = new HashMap<>();
    int n1;
    int n2;
    int arr1[];
    int arr2[];
    public FindSumPairs(int[] nums1, int[] nums2) {

        n1 = nums1.length;
        n2 = nums2.length;

        arr1 = new int[n1];
        arr2 = new int[n2];

        for (int i = 0; i < n1; i++) {
            arr1[i] = nums1[i];
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = nums2[i];
        }

        for (int val : nums2) {
            mp.put(val, mp.getOrDefault(val, 0) + 1);
        }
    }
    
    public void add(int index, int val) {
        int num = arr2[index];
        mp.put(num, mp.get(num) - 1);
        arr2[index] += val;
        mp.put(arr2[index], mp.getOrDefault(arr2[index], 0) + 1);
    }
    
    public int count(int tot) {
        int ans = 0;
        for (int i = 0; i < n1; i++) {
            int val = tot - arr1[i];
            ans += mp.getOrDefault(val, 0);
        }
        return ans;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */