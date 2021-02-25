class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[10];
        
        dfs(k, n, list, res, visited, 0, 0);
        
        return res;
    }
    
    private void dfs(int k, int n,  List<Integer> list, List<List<Integer>> res, boolean[] visited, int sum, int start) {
        if (list.size() < k && sum > n)
            return;
        if (list.size() == k) {
            if (sum == n) {
                res.add(new ArrayList(list));
            }
            return;
        }
        
        for (int i = start; i < 9; i++) {
            if (visited[i + 1])
                continue;
            visited[i + 1] = true;
            list.add(i + 1);
            dfs(k, n, list, res, visited, sum + i + 1, i + 1);
            list.remove(list.size() - 1);
            visited[i + 1] = false;
        }
    }
}