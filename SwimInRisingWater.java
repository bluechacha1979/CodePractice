class Solution {
    int[] dx = new int[]{0, 0, 1, -1};
    int[] dy = new int[]{1, -1, 0, 0};
    public int swimInWater(int[][] grid) {
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        queue.add(new int[]{0,0});
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        
        int res = grid[0][0];
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            
            if ((x == grid.length - 1) && (y == grid[0].length - 1)) {
                return Math.max(res, grid[x][y]);
            }
            
            res = Math.max(res, grid[x][y]);
            
            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];
          
                if (next_x < 0 || next_x > grid.length - 1 || next_y < 0 || next_y > grid[0].length - 1 || visited[next_x][next_y])
                    continue;
                visited[next_x][next_y] = true;
                queue.add(new int[]{next_x, next_y});
            }
        }
        
        return -1;
    }
}