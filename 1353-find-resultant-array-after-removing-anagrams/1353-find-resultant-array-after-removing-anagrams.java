class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> list=new ArrayList<>();
        String last="";
        for(int i=0;i<words.length;i++) {
            char[] c=words[i].toCharArray();
            Arrays.sort(c);
            String an=new String (c);
            if(!an.equals(last)) {
                list.add(words[i]);
                last=an;
            }
        }
        return list;
    }
}