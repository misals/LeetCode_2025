class Solution {
    public int numTrees(int n) {

        if (n <= 2) {
            return n;
        }

        int[] arr = new int[n+1];

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            int sum = 0;

            for (int j = 1; j <= i; j++) {
                int leftBST = arr[j - 1];
                int rightBST = arr[i - j];

                sum += leftBST * rightBST;
            }

            arr[i] = sum;
        }
        return arr[n];
    }
}