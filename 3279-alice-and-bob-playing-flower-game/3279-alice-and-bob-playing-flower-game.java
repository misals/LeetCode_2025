class Solution {
    public long flowerGame(int n, int m) {
    
        long nEven = n / 2;
        long nOdd = n % 2 == 0 ? n / 2 : (n / 2) + 1;

        long mEven = m / 2;
        long mOdd = m % 2 == 0 ? m / 2 : (m / 2) + 1;

        return nEven * mOdd + nOdd * mEven;
    }
}