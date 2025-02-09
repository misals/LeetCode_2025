class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        int upperDiagonal = 1;

        while (upperDiagonal < n) {
            int i = 0;
            int j = upperDiagonal;

            List<Integer> list = new ArrayList<>();

            while (i < n && j < n) {
                list.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(list);
            i = 0;
            j = upperDiagonal;
            while (i < n && j < n) {
                grid[i][j] = list.get(i);
                i++;
                j++;
            }
            upperDiagonal++;
        }

        int lowerDiagonal = 0;

        while (lowerDiagonal < n) {
            int i = lowerDiagonal;
            int j = 0;

            List<Integer> list = new ArrayList<>();

            while (i < n && j < n) {
                list.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(list, Collections.reverseOrder());
            i = lowerDiagonal;
            j = 0;
            while (i < n && j < n) {
                grid[i][j] = list.get(j);
                i++;
                j++;
            }
            lowerDiagonal++;
        }

        return grid;
    }
}