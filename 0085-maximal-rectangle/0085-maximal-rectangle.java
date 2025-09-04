class Solution {
    public int findMaxHistogram(int[] nums) {
        int n = nums.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = st.peek() + 1;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            st.pop();
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                right[i] = n - 1;
            } else {
                right[i] = st.peek() - 1;
            }
            st.push(i);
        }

        int maxi = 0;

        for (int i = 0; i < n; i++) {
            maxi = Math.max(maxi, nums[i] * (right[i] - left[i] + 1));
        }
        return maxi;
    }

    public int maximalRectangle(char[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == '1') {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 1) {
                        matrix[i][j] = 1 + matrix[i - 1][j];
                    } else {
                        matrix[i][j] = 0;
                    }
                }
            }
            int val = findMaxHistogram(matrix[i]);
            ans = Math.max(ans, val);
        }
        return ans;
    }
}