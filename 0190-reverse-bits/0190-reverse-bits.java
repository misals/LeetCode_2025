class Solution {
    public int reverseBits(int x) {
        int b = 0;
        for(int i = 0;i<32;i++){
            b<<=1;
            b|=( x &1);
            x>>=1;
        }
        return b;
    }
}