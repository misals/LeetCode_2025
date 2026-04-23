class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int cnt = 0;
        int endTime = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < endTime) {
                cnt++;
            } else {
                endTime = intervals[i][1];
            }
        }
        return cnt;
    }
}