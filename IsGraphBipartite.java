class Solution {
    public boolean isBipartite(int[][] graph) {
        
        int[] colors = new int[graph.length ];
      
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] != 0)
                continue;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            colors[i] = 1;
            
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int next : graph[curr]) {
                    if (colors[next] != 0) {
                        if (colors[next] != colors[curr] * (-1))
                            return false;
                    }
                    else {
                        colors[next] = colors[curr] * (-1);
                        queue.add(next);
                    }
                }
            }
        }
        
        return true;
    }
}