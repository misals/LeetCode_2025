class Solution {
public:
    bool solve(int ind, int tar, vector<vector<int>> &dp, vector<int> &nums) {
        if(tar == 0) return true;
        if(ind == 0) return nums[0] == tar;
        
        if(dp[ind][tar] != -1) return dp[ind][tar];
        
        bool notPick = solve(ind - 1, tar, dp, nums);
        bool pick = false;
        if(tar >= nums[ind]) {
            pick = solve(ind - 1, tar - nums[ind], dp, nums);
        }
        
        return dp[ind][tar] = pick | notPick;
    }
    bool canPartition(vector<int>& nums) {
        int target = 0;
        int n = nums.size();
        for(auto it : nums) {
            target += it;
        }
        if(target % 2 != 0) {
            return false;
        }
        target /= 2;
        vector<vector<int>> dp(n, vector<int> (target+1, -1));
        
        return solve(n-1, target, dp, nums);
    }
};