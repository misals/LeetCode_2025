class Solution {
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};

    public boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return false;
        }
        return true;
    }

    public void dfs(int i, int j, int startColor, int color, int n, int m, int[][] image) {

        for (int ind = 0; ind < 4; ind++) {
            image[i][j] = color;

            int x = i + dx[ind];
            int y = j + dy[ind];

            if (isValid(x, y, n, m) && image[x][y] == startColor && image[x][y] != color) {
                dfs(x, y, startColor, color, n, m, image);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int tempColor = image[sr][sc];

        dfs(sr, sc, tempColor, color, n, m, image);

        image[sr][sc] = color;

        return image;
    }
}