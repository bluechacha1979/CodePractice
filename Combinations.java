class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        dfs(n, k, list, res, 1);
        
        return res;
    }
    
    private void dfs(int n, int k, List<Integer> list, List<List<Integer>> res, int start) {
        if (list.size() == k) {
            res.add(new ArrayList(list));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            list.add(i);
            dfs(n, k, list, res, i + 1);
            list.remove(list.size() - 1);
        }
    }
}