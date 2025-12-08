class Solution {
    public int countTriples(int n) {
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                    int a = i * i;
                    int b = j * j;

                    int sum = a + b;

                    int k = (int)Math.sqrt(sum);

                    if (k * k == sum && k <= n) {
                        ans++;
                    }
                
            }
        }
        return ans;
    }
}