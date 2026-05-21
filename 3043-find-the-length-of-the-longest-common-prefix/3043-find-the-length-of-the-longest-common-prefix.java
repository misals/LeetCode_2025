class Solution {
    public int checkLength(int num) {
        int cnt = 0;

        while (num != 0) {
            cnt++;

            num /= 10;
        }
        return cnt;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = arr1[i];

            while (num != 0) {
                mp.put(num, 1);

                num /= 10;
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            int num = arr2[i];

            while (num != 0) {
                if (mp.containsKey(num)) {
                    int len = checkLength(num);

                    ans = Math.max(ans, len);
                }
                num /= 10;
            }
        }

        return ans;
    }
}