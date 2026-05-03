class Solution {
    public int reverse(int n) {
        int rev = 0;

        while (n != 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }
        return rev;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int sumOfPrimesInRange(int n) {
        int m = reverse(n);

        int mini = Math.min(n, m);
        int maxi = Math.max(n, m);

        int ans = 0;

        for (int i = Math.max(2, mini); i <= maxi; i++) {
            if (isPrime(i)) {
                ans += i;
            }
        }
        return ans;
    }
}