class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Integer> dist = new HashMap<>();
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for (int[] time : times) {
            int src = time[0];
            int dst = time[1];
            int distance = time[2];
            
            if (!graph.containsKey(src)) {
                graph.put(src, new ArrayList<>());
            }
            
            graph.get(src).add(new int[]{dst, distance});
        }
        
        boolean[] visited = new boolean[N + 1];
        
        for (int i = 1; i <=N; i++) {
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(K, 0);
        
        int curr_node = K;
        while(true) {
            int candidate = -1;
            int min_dist = Integer.MAX_VALUE;
            
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && dist.get(i) < min_dist) {
                    min_dist = dist.get(i);
                    candidate = i;
                }
            }
            
            if (candidate < 0)
                break;
            visited[candidate] = true;
            if (graph.containsKey(candidate)) {
                for (int[] next : graph.get(candidate)) {
                    dist.put(next[0], Math.min(dist.get(candidate) + next[1], dist.get(next[0])));
                }
            }
        }
        
        int ans = 0;
        
        for (int i = 1; i <= N; i++) { 
            if (dist.get(i) == Integer.MAX_VALUE)
                return -1;
            ans = Math.max(ans, dist.get(i));
        }
        
        return ans;
    }
}