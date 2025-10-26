class Bank {
    long[] bank;
    int n;
    public Bank(long[] balance) {
        n = balance.length;
        bank = new long[n];
        bank = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if (account1 - 1 < n && account2 - 1 < n && bank[account1 - 1] >= money) {
            bank[account1 - 1] -= money;
            bank[account2 - 1] += money;
            return true;
        } 
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if (account - 1 < n) {
            bank[account - 1] += money;
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if (account - 1 < n && bank[account - 1] >= money) {
            bank[account - 1] -= money;
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */