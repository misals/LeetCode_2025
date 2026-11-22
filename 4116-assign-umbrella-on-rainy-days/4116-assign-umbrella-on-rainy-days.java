class Solution {
    public String[] assignUmbrella(int[] rain) {
        int n = rain.length;

        String[] result = new String[n];

        int alice = 0;
        int bob = 0;

        for (int i = 0; i < n; i++) {
            if (i + 1 < n && rain[i] == 1 && rain[i + 1] == 1) {
                if (alice <= bob) {
                    result[i] = "Alice";
                    alice++;
                } else {
                    result[i] = "Bob";
                    bob++;
                }
            } else if (rain[i] == 1) {
                result[i] = "Bob";
                bob++;
            } else {
                result[i] = "None";
            }
        }

        return result;
    }
}