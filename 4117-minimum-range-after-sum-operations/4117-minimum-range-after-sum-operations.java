class Solution {
    public int minRange(int a, int b, int c) {
        int[] arr = new int[3];

        arr[0] = a;
        arr[1] = b;
        arr[2] = c;

        boolean flag = true;

        int ans = Integer.MAX_VALUE;

        while (flag) {
            Arrays.sort(arr);

            ans = Math.min(ans, arr[2] - arr[0]);

            if (arr[0] + arr[1] < arr[2]) {
                arr[2] = arr[0] + arr[1];
            } else {
                flag = false;
            }
        }

        return ans;
    }
}