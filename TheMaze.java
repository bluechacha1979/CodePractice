class Solution {
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }
    
    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (start[0] == destination[0] && start[1] == destination[1])
            return true; 
        if (visited[start[0]][start[1]])
            return false;
        visited[start[0]][start[1]] = true;
        
        int[][] next_dest = getNext(maze, start);
        
        boolean res = false;
        for (int[] next : next_dest) {
            res = dfs(maze, next, destination, visited);
            if (res)
                break;
        }
        return res;
    }
    
    private int[][] getNext(int[][] maze, int[] start) {
        int[][] next_dest = new int[4][2];    
        for (int i = 0; i < 4; i++) {
            int x = start[0];
            int y = start[1];           
            while (x + dx[i] >= 0 && x + dx[i] <= maze.length - 1 && y + dy[i] >= 0 && y + dy[i]<= maze[0].length - 1 && maze[x + dx[i]][y + dy[i]] != 1) {
                x = x + dx[i];
                y = y + dy[i];
            }
            next_dest[i] = new int[]{x, y};     
        }
        return next_dest;
    }
}