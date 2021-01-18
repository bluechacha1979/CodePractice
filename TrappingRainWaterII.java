class Solution {
    int[] dx = new int[] {0, 0, 1, -1};
    int[] dy = new int[] {1, -1, 0, 0};
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);       
        int m = heightMap.length;
        int n = heightMap[0].length;      
        boolean[][] visited = new boolean[m][n];
        //add first column and last column to heap
        for (int i = 0; i < m; i++) {
            minHeap.add(new int[]{i, 0, heightMap[i][0]});
            minHeap.add(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        //add first row and last row to heap
        for (int j = 1; j < n - 1; j++) {
            minHeap.add(new int[]{0, j, heightMap[0][j]});
            minHeap.add(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }      
        //bfs while popping from minHeap
        int res = 0;
        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
    
            for (int i = 0; i < 4; i++) {
                int next_x = curr[0] + dx[i];
                int next_y = curr[1] + dy[i];
                
                if (next_x < 0 || next_x > m - 1 || next_y < 0 || next_y > n - 1 || visited[next_x][next_y]) {
                    continue;
                }
                res += Math.max(0, curr[2] - heightMap[next_x][next_y]);
                visited[next_x][next_y] = true;
                minHeap.add(new int[]{next_x, next_y, Math.max(heightMap[next_x][next_y], curr[2])});
            }
        }        
        return res;
    }
}