class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[0] - a2[0]);
        
        Set<String> visited = new HashSet<>();
        pq.add(new int[]{0, 0, 0});
        Set<Integer> forbid = new HashSet<>();
        
        for (int num : forbidden) {
            forbid.add(num);
        }
        
        int maxLimit = 2000 + 2 * b;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int steps = curr[0];
            int idx = curr[1];
            int direction = curr[2];
            
            if (idx == x)
                return steps;
            
            //moving forward
            if (idx + a <= maxLimit && !visited.contains(idx+a+","+0) && !forbid.contains(idx + a)) {
                visited.add(idx+a+","+0);
                pq.add(new int[]{steps + 1, idx + a, 0});
            }
            
            //move backward
            if (idx - b >=0 && !visited.contains(idx-b+","+1) && !forbid.contains(idx - b) && direction != 1) {
                visited.add(idx-b+","+1);
                pq.add(new int[]{steps + 1, idx - b, 1});
            }
        }
        
        return -1;
    
    }
}