class Solution {
    public int findLaregstRectangle(int[] arr) {
        int n = arr.length;
        int ans = 0;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
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
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            
            if (st.isEmpty()) {
                right[i] = n - 1;
            } else {
                right[i] = st.peek() - 1;
            }
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] + 1) * arr[i]);
        }
        return ans;
    }

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = matrix[i][j] == '1' ? 1 : 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > 0) {
                    arr[i][j] = arr[i][j] + arr[i - 1][j];
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int val = findLaregstRectangle(arr[i]);
            ans = Math.max(ans, val);
        }

        return ans;
    }
}