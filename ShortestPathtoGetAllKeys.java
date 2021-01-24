class Solution {
    class State {
        int keys;
        int i;
        int j;
        
        public State(int keys, int i, int j) {
            this.keys = keys;
            this.i = i;
            this.j = j;
        }
    }
    
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    public int shortestPathAllKeys(String[] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length();
        int start_i = -1, start_j = -1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '@') {
                    start_i = i;
                    start_j = j;
                }
                
                if (c >= 'a' && c <= 'f') {
                    max = Math.max(max, c - 'a' + 1);
                }
            }
        }
        
        State start = new State(0, start_i, start_j);
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        visited.add(0 + " " + start_i + " " + start_j);
        queue.offer(start);
        
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State curr = queue.poll();
                
                if (curr.keys == (1 << max) - 1){
                    return steps;
                }
                
                for (int k = 0; k < 4; k++) {
                    int next_x = curr.i + dx[k];
                    int next_y = curr.j + dy[k];
                    int keys = curr.keys;
                    if (next_x < 0 || next_x > m - 1 || next_y < 0 || next_y > n - 1)
                        continue;
                    char c = grid[next_x].charAt(next_y);
                    if (c == '#') {
                            continue;
                        }
                    if (c >= 'a' && c <= 'f') {
                        keys |= 1 << (c - 'a');
                    }
                    
                    if (c >= 'A' && c <= 'F' && ((keys >> (c - 'A')) & 1) == 0) {
                        continue;
                    } 
                    if (!visited.contains(keys + " " + next_x + " " + next_y)) {
                        visited.add(keys + " " + next_x + " " + next_y);
                        queue.add(new State(keys, next_x, next_y));
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}