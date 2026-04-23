class Solution {
    public long[] distance(int[] nums) {

        long[] arr = new long[nums.length];

        HashMap<Integer,List<Long>> map = new HashMap<>();

        for(int i:nums){

            if(!map.containsKey(i)) map.put(i,new ArrayList<>());
        }

        for(int i=0;i<nums.length;i++){

            List<Long> temp = map.get(nums[i]);
            if(temp.isEmpty()){
                temp.add((long)i);
                temp.add((long)1);
            }
            else{

                long sum = temp.get(0);
                long freq = temp.get(1);
                arr[i]+= (long)Math.abs(freq*i - sum);
                temp = new ArrayList<>();
                temp.add((long)sum+i);
                temp.add((long)freq+1);
                map.put(nums[i],temp);
            }
        }

         map = new HashMap<>();

        for(int i:nums){

            if(!map.containsKey(i)) map.put(i,new ArrayList<>());
        }

        for(int i=nums.length-1;i>=0;i--){

            List<Long> temp = map.get(nums[i]);
            if(temp.isEmpty()){
                temp.add((long)i);
                temp.add((long)1);
            }
            else{

                long sum = temp.get(0);
                long freq = temp.get(1);
                arr[i]+= (long)Math.abs(freq*i - sum);
                temp = new ArrayList<>();
                temp.add((long)sum+i);
                temp.add((long)freq+1);
                map.put(nums[i],temp);
            }
        }
        return arr;
    }
}