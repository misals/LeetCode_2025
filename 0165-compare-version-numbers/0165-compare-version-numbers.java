class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");

        int n = str1.length;
        int m = str2.length;
        System.out.println(n + " " + m);

        for (int i = 0; i < Math.max(n, m); i++) {
            int val1 = 0;
            int val2 = 0;

            if (i < n) {
                val1 = Integer.parseInt(str1[i]);
            } 
            if (i < m) {
                val2 = Integer.parseInt(str2[i]);
            }
            if (val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            }  
        }
        return 0;
    }
}