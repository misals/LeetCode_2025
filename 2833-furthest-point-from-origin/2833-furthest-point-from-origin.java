class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();

        int origin = 0;

        int space = 0;

        for (int i = 0; i < n; i++) {
            if (moves.charAt(i) == 'R') {
                origin++;
            } else if (moves.charAt(i) == 'L') {
                origin--; 
            } else {
                space++;
            }
        }

        return Math.abs(origin) + space;
    }
}