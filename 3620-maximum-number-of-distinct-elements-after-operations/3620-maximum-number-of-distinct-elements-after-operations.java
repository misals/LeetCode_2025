class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>();

        int lastUsed = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            int rangeStart = Math.max(lastUsed+1 , nums[i]-k);
            int rangeEnd = nums[i]+k;
            
            if(rangeStart <= rangeEnd)
            {
                set.add(rangeStart);
                lastUsed = rangeStart;
            }
        }
        return set.size();
    }
}