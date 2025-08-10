class Solution {
    private int freq[] = new int[10];
    public boolean reorderedPowerOf2(int n) {
        while (n > 0){
            freq[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 31; i++)
            if (check(1 << i))
                return true;
        return false;
    }
    private boolean check(int n){
        int count[] = new int[10];
        while (n > 0){
            count[n % 10]++;
            n /= 10;
        }
        for (int i = 0; i < 10; i++)
            if (freq[i] != count[i])
                return false;
        return true;
    }
}