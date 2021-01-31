class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet(wordList);
        Set<String> visited = new HashSet<>();
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return level;
                }
                List<String> nextWords = getNextWords(curr, visited, dict);
                for (String word : nextWords){
                    queue.add(word);
                    visited.add(word);
                }
            }
            level++;
        }
        
        return 0;
    }
    
    private List<String> getNextWords(String curr, Set<String> visited, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < curr.length(); i++) {
            for (int j = 0; j < 26; j++) {
                if (curr.charAt(i) == (char)(j + 'a'))
                    continue;
                String str = replaceWord(curr, i, (char)(j + 'a'));
                if (!visited.contains(str) && dict.contains(str)){
                    res.add(str);   
                }
            }
        }
        
        return res;
    }
    
      public String replaceWord(String str, int str_index, char c) {      
        char[] chars = str.toCharArray();
        chars[str_index] = c;
        return new String(chars);
    }
}