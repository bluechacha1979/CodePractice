class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        int[] indegree = new int[n];
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        Map<Integer, Set<Integer>> preq = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            adj.put(i, new HashSet<>());
            preq.put(i, new HashSet<>());
        }
        
        for (int[] prerequisite : prerequisites) {
            int c1 = prerequisite[0];
            int c2 = prerequisite[1];
            adj.get(c1).add(c2);
            indegree[c2]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int next : adj.get(curr)) {
                preq.get(next).add(curr);
                preq.get(next).addAll(preq.get(curr));
                indegree[next]--;
                if (indegree[next] == 0)
                    queue.add(next);
            }
        }
        
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            int c1 = query[0];
            int c2 = query[1];
            if (preq.get(c2).contains(c1)) {
                res.add(true);
            }
            else
                res.add(false);
        }
        
        return res;
    }
}