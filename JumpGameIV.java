class Solution {
    public int minJumps(int[] arr) {
        boolean[] visited = new boolean[arr.length];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            if (!graph.containsKey(arr[i])) {
                graph.put(arr[i], new ArrayList<>());
            }
            graph.get(arr[i]).add(i);
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{arr[0], 0});
        visited[0] = true;
        
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int val = curr[0];
                int idx = curr[1];
                if (idx == arr.length - 1)
                    return level;
                
                for (int same_value_idx : graph.get(val)) {
                    if (visited[same_value_idx]) {
                        continue;
                    }
                    visited[same_value_idx] = true;
                    queue.add(new int[]{arr[same_value_idx], same_value_idx});
                }
                
                graph.get(val).clear();
                
                if (idx + 1 < arr.length && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    queue.add(new int[]{arr[idx + 1], idx + 1});
                }

                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    queue.add(new int[]{arr[idx - 1], idx - 1});
                }
            }
                level++;
        }
        
        return -1;
    }
}