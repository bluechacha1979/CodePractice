class Solution {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        int[] inDegree = new int[n + 1];
        HashSet<Integer>[] edges = new HashSet[n + 1];
        
        //initialize edges
        for (int i = 1; i <= n; i++) {
            edges[i] = new HashSet<Integer>();
        }
        
        //initialize indegree
        int count = 0;
        for (int i = 0; i < seqs.size(); i++) {
            int len = seqs.get(i).size();
            count = count + len;
            if (len >= 1 && (seqs.get(i).get(len - 1) < 1 || seqs.get(i).get(len - 1) > n))
                    return false;
            for (int j = 0; j < seqs.get(i).size() - 1; j++) {
                if (seqs.get(i).size() >= 1 && (seqs.get(i).get(j) < 1 || seqs.get(i).get(j) > n))
                    return false;
                if (!edges[seqs.get(i).get(j)].contains(seqs.get(i).get(j + 1))) {
                    edges[seqs.get(i).get(j)].add(seqs.get(i).get(j + 1));
                    inDegree[seqs.get(i).get(j + 1)]++;
                }
            }
        }
        
        if (count < n)
            return false;
        
        //initialize queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0)
                queue.add(i);
        }
        
        //bfs
        int cnt = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1)
                return false;
            int x = (int)queue.poll();
            HashSet<Integer> curr = edges[x];
            for (Integer edge: curr) {
                int next = edge.intValue();
                inDegree[next]--;
                if (inDegree[next] == 0)
                    queue.add(next);
            }
            if (x != org[cnt])
                return false;
            cnt++;
        }
        
        return cnt == n;
    }
}