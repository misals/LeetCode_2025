class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];  // Result array
        Deque<Integer> dq = new ArrayDeque<>();  // Stores indices
        
        for(int i = 0; i < n; i++){
            // Step 1: Remove elements that are out of current window from front
            if(!dq.isEmpty() && dq.peekFirst() <= i - k) 
                dq.removeFirst();
            
            // Step 2: Maintain decreasing order - remove smaller elements from back
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.removeLast();
            }
            
            // Step 3: Add current element to deque
            dq.offer(i);
            
            // Step 4: If window is complete, record maximum
            if(i >= k - 1){
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}