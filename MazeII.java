class Solution {
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int[][] distance = new int[maze.length][maze[0].length];
        for (int[] dist : distance) {
            Arrays.fill(dist, Integer.MAX_VALUE);
        }
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[]{start[0], start[1], 0});     
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int l = curr[2];
            if (distance[x][y] <= l)
                continue;
            distance[x][y] = l;
            
            for (int i = 0; i < 4; i++) {
                int xx = x;
                int yy = y;
                int ll = l;
                while (xx >=0 && xx < maze.length && yy >=0 && yy < maze[0].length && maze[xx][yy] == 0) {
                    xx += dx[i];
                    yy += dy[i];
                    ll++;
                }
                xx -= dx[i];
                yy -= dy[i];
                ll--;
                queue.add(new int[]{xx, yy, ll});
            }         
        }
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE? -1 : distance[destination[0]][destination[1]];
        
    }
}