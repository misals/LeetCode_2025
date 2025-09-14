class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = queries.length;
        String[] res = new String[n];
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(wordlist));
        HashMap<String,String> capital = new HashMap<>();
        HashMap<String,String> changeVowel = new HashMap<>();
        
        for(String w : wordlist){
            String wordLower = w.toLowerCase();
            String removeVowel = wordLower.replaceAll("[aeiou]","*");
            capital.putIfAbsent(wordLower,w);
            changeVowel.putIfAbsent(removeVowel,w);
        }
        for(int i=0;i<n;i++){
            if(uniqueWords.contains(queries[i])){
            res[i] = queries[i];
            continue;}
            String wordLower = queries[i].toLowerCase();
            String removeVowel = wordLower.replaceAll("[aeiou]","*");
            if(capital.containsKey(wordLower))
            res[i] = capital.get(wordLower);
            else if(changeVowel.containsKey(removeVowel))
            res[i] = changeVowel.get(removeVowel);
            else
            res[i] = "";
        }
        return res;
    }
}