class Solution {
    public int[][] insert(int[][] intervals, int[] newIntervals) {
        int n = intervals.length;

        List<int[]> result = new ArrayList<>();

        int i = 0;

        while (i < n && intervals[i][1] < newIntervals[0]) {
            result.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newIntervals[1]) {
            newIntervals[0] = Math.min(newIntervals[0], intervals[i][0]);
            newIntervals[1] = Math.max(newIntervals[1], intervals[i][1]);
            i++;
        }

        result.add(newIntervals);

        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}