class Solution {
    public String clearStars(String s) {
        List<Stack<Integer>> listOfStacks = new ArrayList<>();

        int n = s.length();

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < 26; i++) {
            listOfStacks.add(new Stack<>());
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                for (int j = 0; j < 26; j++) {
                    if (listOfStacks.get(j).size() > 0) {
                        int ind = listOfStacks.get(j).peek();
                        sb.setCharAt(ind, '*');
                        listOfStacks.get(j).pop();
                        break;
                    }
                }
            } else {
                int ind = sb.charAt(i) - 'a';
                listOfStacks.get(ind).push(i);
            }
        }

        String ans = "";
        s = sb.toString();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '*') {
                ans = ans + s.charAt(i);
            }
        } 
        return ans;
        
    }
}