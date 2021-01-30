class Solution {
    public int shortestPathLength(int[][] graph) {
        int mask = 1;
        int target = 0;
        Set<String> paths = new HashSet<>();
        
        Queue<int[]> queue = new LinkedList<>();
        
        
        for (int i = 0; i < graph.length; i++) {
            mask = 1 << i;
            target |= mask;
            queue.add(new int[]{mask, i});
            paths.add(mask + "+" + i);
        }
        
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int tail = curr[1];
                if (curr[0] == target)
                    return level;
                for (int next : graph[tail]) {
                    int cover = curr[0] | (1 << next);
                    String path = cover + "+" + next;
                    if (!paths.contains(path)) {
                        paths.add(path);
                        queue.add(new int[]{cover, next});
                    }
                }
            }
            level++;
        }
        
        return -1;
    }
}