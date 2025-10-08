class Solution {
    public int findLowerBound(int array[], long key) {
        int low = 0, high = array.length;
        int mid;

        while (low < high) {
            mid = low + (high - low) / 2;

            if (key <= array[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if (low < array.length && array[low] < key) {
            low++;
        }
        return low;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;

        int[] ans = new int[n];
        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
            long key = success / spells[i];

            if (success % spells[i] != 0) {
                key++;
            }

            int ind = findLowerBound(potions, key);
            
            ans[i] = m - ind;
        }

        return ans;
    }
}