class Solution {
    int MOD = 1000000007;
    public int countPermutations(int[] complexity) {
        int n = complexity.length;

        for (int i = 1; i < n; i++) {
            if (complexity[i] <= complexity[0]) {
                return 0;
            }
        }

        long ans = 1;

        for (int i = 1; i < n; i++) {
            ans = (ans * i) % MOD;
        }

        return (int)ans;
    }
}