class Solution {
    public boolean canReach(int[] arr, int start) {
         Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            
            if (arr[curr] == 0)
                return true;
            
            int next1 = curr + arr[curr];
            int next2 = curr - arr[curr];
            
            if (next1 < arr.length && !visited[next1]) {
                visited[next1] = true;
                queue.add(next1);
            }
            
            if (next2 >= 0 && !visited[next2]) {
                visited[next2] = true;
                queue.add(next2);
            }
            
        }
        
        return false;
    }
}