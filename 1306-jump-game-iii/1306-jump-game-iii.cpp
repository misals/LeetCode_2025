class Solution {
public:
    bool solve(int ind, vector<int> &arr, vector<bool> &dp) {
        if(ind < 0 || ind >= arr.size()) {
            return false;
        }
        if(arr[ind] == 0) return true;
        if(dp[ind] == 1) return false;
        
        dp[ind] = true;
        
        bool back = solve(ind - arr[ind], arr, dp);
        bool front = solve(ind + arr[ind], arr, dp);
        
        return back || front;
    }
    
    bool canReach(vector<int>& arr, int start) {
        int n = arr.size();
        vector<bool> dp(n, 0);
        
        return solve(start, arr, dp);
    }
};