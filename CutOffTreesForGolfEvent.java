class Solution {
    private static int[] dx = new int[]{0, 0, 1, -1};
    private static int[] dy = new int[]{1, -1, 0, 0};
    
    public int cutOffTree(List<List<Integer>> forest) {
        int tree_count = 0;
        int m = forest.size();
        int n = forest.get(0).size();
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    queue.add(new int[]{i, j, forest.get(i).get(j)});
                }
            }
        }
        
        //find each minimum step from start to the next mininum height tree
        //if minimum step found, update start to next mininum height tree
        int[] start = new int[2];
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] next_tree = queue.poll();
            int step = helper(forest, start, next_tree);

            if (step < 0) return -1;
            sum += step;

            start[0] = next_tree[0];
            start[1] = next_tree[1];
        }

        return sum;
    }
    
    private int helper(List<List<Integer>> forest, int[] start, int[] next_tree) {
        int m = forest.size();
        int n = forest.get(0).size();
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                int level= curr[2];
            
                if (x == next_tree[0] && y == next_tree[1])
                    return level;
            
                for (int i = 0; i < 4; i++) {
                    int next_x = x + dx[i];
                    int next_y = y + dy[i];
                    if (next_x < 0 || next_x > m - 1 || next_y < 0 || next_y > n - 1 || visited[next_x][next_y])
                        continue;
                    if (forest.get(next_x).get(next_y) == 0)
                        continue;
                    visited[next_x][next_y] = true;
                    queue.add(new int[]{next_x, next_y, level + 1}); 
                }
        }
        
        return -1;
    }
}