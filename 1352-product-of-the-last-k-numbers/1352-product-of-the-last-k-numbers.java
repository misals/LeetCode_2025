class ProductOfNumbers {
    ArrayList list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int val = 1;
        int n = list.size() - 1;

        while (k-- > 0) {
            val = val * (int)list.get(n);
            n--;
        }
        return val;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */