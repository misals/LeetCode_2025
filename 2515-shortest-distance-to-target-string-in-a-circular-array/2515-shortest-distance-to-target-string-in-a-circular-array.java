class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;

        int curr = startIndex;
        int n1 = n;
        int cnt = 0;

        int ans = Integer.MAX_VALUE;

        while (n1-- > 0) { 
            int ind = curr % n;
            if (target.equals(words[ind])) {
                ans = Math.min(ans, cnt);
                break;
            }
            curr++;
            cnt++;
        }

        curr = startIndex;
        n1 = n;
        cnt = 0;

        while(n1-- > 0) {
            int ind = curr % n;
            if (target.equals(words[ind])) {
                ans = Math.min(ans, cnt);
                break;
            }
            curr--;
            if (curr < 0) {
                curr = n - 1;
            }
            cnt++;
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}