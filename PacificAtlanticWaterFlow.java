class Solution {
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return res;
        int m = matrix.length, n = matrix[0].length;
        Queue<int[]> pQueue = new LinkedList<>();
        Queue<int[]> aQueue = new LinkedList<>();
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];        
        for (int i = 0; i < m; i++) {
            pQueue.add(new int[]{i,0});
            pVisited[i][0] = true;
            aQueue.add(new int[]{i, n - 1});
            aVisited[i][n - 1] = true;
        }        
        for (int j = 0; j < n; j++) {
            pQueue.add(new int[]{0,j});
            pVisited[0][j] = true;
            aQueue.add(new int[]{m - 1, j});
            aVisited[m - 1][j] = true;
        }      
        bfs(matrix, pQueue, pVisited);
        bfs(matrix, aQueue, aVisited);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pVisited[i][j] && aVisited[i][j]) {
                    List<Integer> pair = new ArrayList<>();
                    pair.add(i);
                    pair.add(j);
                    res.add(pair);
                }
            }
        }
        return res;
    }
    
    private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited){
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                if (next_x < 0 || next_x > matrix.length - 1 || next_y < 0 || next_y > matrix[0].length - 1 || visited[next_x][next_y])
                    continue;
                if (matrix[next_x][next_y] < matrix[x][y])
                    continue;
                visited[next_x][next_y] = true;
                queue.add(new int[]{next_x, next_y});
            }
        }
        
    }
}