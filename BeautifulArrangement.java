class Solution {
    int res = 0; 
    public int countArrangement(int N) {
        
        HashSet<Integer> visited = new HashSet<>();
        
        dfs(1, N, visited);
        
        return res;
    }
    
    public void dfs (int pos, int N, HashSet<Integer> visited) {
        if (pos > N) {
            res++;
            return;
        }
        
        for (int i = 1; i <= N; i++) {
            if(visited.contains(i))
                continue;
            if (i % pos != 0 && pos % i != 0)
                continue;
            visited.add(i);
            dfs(pos + 1, N, visited);
            visited.remove(i);
        }
    }
}