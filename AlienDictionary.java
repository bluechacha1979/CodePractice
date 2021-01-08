class Solution {
    public String alienOrder(String[] words) {
  
     Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegree.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }
        
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            
            if (word1.length() > word2.length() && word1.startsWith(word2))
                return "";
            
            for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    graph.get(c1).add(c2);
                    indegree.put(c2, indegree.get(c2) + 1);
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        
        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.add(c);
            }
        }
        
        while (!queue.isEmpty()) {
            char curr = queue.poll();
            sb.append(curr);
            
            for (char c : graph.get(curr)) {
                indegree.put(c, indegree.get(c) - 1);
                if (indegree.get(c) == 0) {
                    queue.add(c);
                }
            }
        }
        
        if (sb.length() < indegree.size()) 
            return "";
        
        return sb.toString();
 
    }
}