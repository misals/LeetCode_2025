class Solution {
    public boolean checkPrime(String s) {
        Integer num = Integer.valueOf(s);

        boolean isPrime = true;

        if (num <= 1) { 
            isPrime = false;
        } else if (num == 2) { 
            isPrime = true;
        } else if (num % 2 == 0) { 
            isPrime = false;
        } else {
            for (int i = 3; i <= Math.sqrt(num); i += 2) {
                if (num % i == 0) {
                    isPrime = false;
                    break; 
                }
            }
        }
        return isPrime;
    }

    public boolean completePrime(int num) {
        String s = Integer.toString(num);

        int n = s.length();

        for (int i = 1; i < n; i++) {
            String temp = s.substring(0, i);

            if (!checkPrime(temp)) {
                return false;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            String temp = s.substring(i, n);

            if (!checkPrime(temp)) {
                return false;
            }
        }
        return true;
    }
}