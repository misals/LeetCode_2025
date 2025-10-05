class Solution {
    int n;
    int m;

    public void dfs(int i, int j, int prev, int[][] heights, int[][] ocean) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return;
        }
        if (ocean[i][j] == 1) {
            return;
        }
        if (heights[i][j] < prev) {
            return;
        }

        ocean[i][j] = 1;

        dfs(i - 1, j, heights[i][j], heights, ocean);
        dfs(i + 1, j, heights[i][j], heights, ocean);
        dfs(i, j - 1, heights[i][j], heights, ocean);
        dfs(i, j + 1, heights[i][j], heights, ocean);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;

        int[][] pacific = new int[n][m];
        int[][] atlantic = new int[n][m];

        for (int i = 0; i < n; i++) {
            dfs(i, 0, Integer.MIN_VALUE, heights, pacific);
            dfs(i, m - 1, Integer.MIN_VALUE, heights, atlantic);
        }

        for (int i = 0; i < m; i++) {
            dfs(0, i, Integer.MIN_VALUE, heights, pacific);
            dfs(n - 1, i, Integer.MIN_VALUE, heights, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
}