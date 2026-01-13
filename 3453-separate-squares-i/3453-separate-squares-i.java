class Solution {

    class Info {
        double lowerArea;
        double upperArea;

        Info(double lowerArea, double upperArea) {
            this.lowerArea = lowerArea;
            this.upperArea = upperArea;
        }
    }

    public Info getBothArea(int[][] squares, double midY) {
        double lowerArea = 0;
        double upperArea = 0;

        for (int i = 0; i < squares.length; i++) {
            double yi = (double) squares[i][1];
            double li = (double) squares[i][2];
            double top = yi + li; //top 

            if (midY > yi && midY < top) {
                lowerArea += (midY - yi) * li;
                upperArea += (top - midY) * li;
            } else if (yi >= midY) {
                upperArea += li * li;
            } else {
                lowerArea += li * li;
            }
        }

        return new Info(lowerArea, upperArea);
    }

    public double separateSquares(int[][] squares) {
        double left = 0;
        double right = 0;

        for (int[] square : squares) {
            right = Math.max(right, square[1] + square[2]);
        }

        for (int i = 0; i < 60; i++) {
            double mid = left + (right - left) / 2.0;

            Info info = getBothArea(squares, mid);
            double lArea = info.lowerArea;
            double uArea = info.upperArea;

            if (lArea < uArea) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}