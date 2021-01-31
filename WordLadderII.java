class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Map<String, List<String>> neighbors = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        
        List<List<String>> res = new ArrayList<>();
        List<String> path = new ArrayList<>();
        
        dict.add(beginWord);
        bfs(beginWord, endWord, dict, neighbors, distance);
        dfs(beginWord, endWord, dict, neighbors, distance, res, path);
        
        return res;
    }
    
    private void bfs (String beginWord, String endWord, Set<String> dict,  Map<String, List<String>> neighbors, Map<String, Integer> distance) {
         for (String word : dict) {
            neighbors.put(word, new ArrayList<>());
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        distance.put(beginWord, 0);
          
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean found = false;
            for (int i = 0; i < size; i++){
                String curr = queue.poll();
                int curr_dist = distance.get(curr);
                for (String word : getNext(curr, dict)) {
                    neighbors.get(curr).add(word);
                    if(!distance.containsKey(word)) {
                        distance.put(word, curr_dist + 1);
                         if (word.equals(endWord))
                             found = true;
                        else
                            queue.add(word);
                    }
                }
                if (found)
                break;
            }
        }
    }
    
    private void dfs(String beginWord, String endWord, Set<String> dict,  Map<String, List<String>> neighbors, Map<String, Integer> distance,List<List<String>> res, List<String> path) {
        path.add(beginWord);
        if (endWord.equals(beginWord)) {
            res.add(new ArrayList<>(path));
        }
        else {
            for (String word : neighbors.get(beginWord)) {
                if (distance.get(word) == distance.get(beginWord) + 1) {
                    dfs(word, endWord, dict, neighbors, distance, res, path);
                }
            }
        }
        
        path.remove(path.size() - 1);
    }
    
    private List<String> getNext(String node, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
  char chs[] = node.toCharArray();

  for (char ch ='a'; ch <= 'z'; ch++) {
      for (int i = 0; i < chs.length; i++) {
          if (chs[i] == ch) continue;
          char old_ch = chs[i];
          chs[i] = ch;
          if (dict.contains(String.valueOf(chs))) {
              res.add(String.valueOf(chs));
          }
          chs[i] = old_ch;
      }

  }
  return res;
    }
}