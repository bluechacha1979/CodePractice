class Solution {
    private static int[] dx = new int[] {0, 0, 1, -1};
    private static int[] dy = new int[] {1, -1, 0, 0};
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        dfs(grid, 0, 0, queue, visited);
        
        int cost = 0;
        if (visited[m - 1][n - 1])
                return cost;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                for (int k = 0; k < 4; k++) {
                    int next_x = x + dx[k];
                    int next_y = y + dy[k];
                    if (next_x < 0 || next_x > grid.length - 1 || next_y < 0 || next_y > grid[0].length - 1 || visited[next_x][next_y])
                        continue;
                    dfs(grid, next_x, next_y, queue, visited);    
                    if (visited[m - 1][n - 1])
                        return cost + 1;
                }
            }
            cost++;
        }
        
        return -1;
    }
    
    private void dfs (int[][] grid, int x, int y, Queue<int[]> queue, boolean[][] visited) {
        
        while (true) {
            queue.add(new int[]{x,y});
            visited[x][y] = true;
            int dir = grid[x][y] - 1;
            x = x + dx[dir];
            y = y + dy[dir];
            
            if (x < 0 || x > grid.length - 1 || y < 0 || y > grid[0].length - 1 || visited[x][y]) {
                break;
            }
        }
    }
}