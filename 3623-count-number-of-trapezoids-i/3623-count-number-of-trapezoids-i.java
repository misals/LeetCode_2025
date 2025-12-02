class Solution {
    public int countTrapezoids(int[][] points) {

        int n = points.length; 

        Map<Integer , Integer> mp = new HashMap<>();
        for(int[] point : points){
            int y_coordinate = point[1];
            mp.put(y_coordinate , mp.getOrDefault(y_coordinate , 0) + 1);
        }

        long mod = 1000000007;
        long ans = 0 , s = 0; 
        for(int val : mp.values()){
            long pair = (long)val * (val - 1) / 2 % mod; 
            ans = (ans + (pair * s)) % mod;
            s = (s + pair) % mod; 
        } 

        return (int)(ans % mod);
    }
}