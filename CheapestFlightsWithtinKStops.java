class Solution {
    int min = Integer.MAX_VALUE;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {    
        Map<Integer, List<int[]>> routes = new HashMap<>();       
        boolean[] visited = new boolean[n];
        for (int[] flight : flights) {
            int city1 = flight[0];
            int city2 = flight[1];
            int cost = flight[2];
            if (!routes.containsKey(city1)) {
                routes.put(city1, new ArrayList<>());
            }
            routes.get(city1).add(new int[]{city2, cost});
        }
        
        visited[src] = true;
        dfs(src, dst, routes, 0, -1, K, visited);
        
        return min == Integer.MAX_VALUE? -1 : min;
    }
    
    private void dfs(int src, int dst, Map<Integer, List<int[]>> routes, int cost, int stop, int K, boolean[] visited) {
        if (src == dst && stop <= K) {
            min = Math.min(cost, min);
            return;
        }
        if (min != -1 && cost > min)
            return; 
        if (stop > K)
            return;
        if (!routes.containsKey (src))
            return;   
        for (int[] next : routes.get(src)) {
            int next_dest = next[0];
            int next_cost = next[1];
            visited[next_dest] = true;
            dfs(next_dest, dst, routes, cost + next_cost, stop + 1, K, visited);
            visited[next_dest] = false;
        }
    }
}