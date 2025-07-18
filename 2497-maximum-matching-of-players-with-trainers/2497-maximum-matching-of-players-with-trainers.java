class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int n = players.length;
        int m = trainers.length;

        int ans = 0;

        int i = 0;
        int j = 0;

        while (i < n) {
            while (j < m && players[i] > trainers[j]) {
                j++;
            }

            if (j == m) {
                break;
            }

            if (players[i] <= trainers[j]) {
                ans++;
            }
            i++;
            j++;
        }
        return ans;
    }
}