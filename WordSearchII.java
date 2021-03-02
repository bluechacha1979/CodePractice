class Solution {
       private static int[] dx = {0, 0, 1, -1};
       private static int[] dy = {1, -1, 0, 0};
    
    public List<String> findWords(char[][] board, String[] words) {
         if (board == null || board.length == 0) {
            return new ArrayList<>();
        }
        if (board[0] == null || board[0].length == 0) {
            return new ArrayList<>();
        }
        
        Map<String, Boolean> prefix = getPrefix(words);
        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                sb.append(board[i][j]);
                dfs(board, res, visited, i, j, prefix, sb);
                visited[i][j] = false;
                 sb.deleteCharAt(sb.length() - 1);
            }
        }
        
        return new ArrayList<>(res);
       
    }
    
    private Map<String, Boolean> getPrefix (String[] words) {
        Map<String, Boolean> map = new HashMap<>();
        
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String str = word.substring(0, i + 1);
                if (!map.containsKey(str)) {
                    map.put(str, false);
                }
            }
            map.put(word, true);
        }
        
        return map;
    }
    
    
    private void dfs (char[][] board, Set<String> res, boolean[][] visited, int i, int j, Map<String, Boolean> map, StringBuilder sb) {
             
            if (!map.containsKey(sb.toString()))
                 return;
        
            if (map.get(sb.toString())) {
                res.add(sb.toString());
            }
                 
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];
                
                if(x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1)
                    continue;
                
                if (visited[x][y])
                    continue;
                
                sb.append(board[x][y]);
                visited[x][y] = true;
                dfs(board, res, visited, x, y, map, sb);
                sb.deleteCharAt(sb.length() - 1);
                visited[x][y] = false;
            }
       
    }
    