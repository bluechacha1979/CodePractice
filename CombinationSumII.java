class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return res;
        
        Arrays.sort(candidates);
        
        List<Integer> list = new ArrayList<>();
        
        dfs(candidates, target, 0, 0, res, list);
        
        return res;
        
    }
    
    private void dfs (int[] candidates, int target, int total, int start, List<List<Integer>> res, List<Integer> list){
        if (total == target) {
            res.add(new ArrayList(list));
            return;
        }
        
        if (total > target)
            return;
        
        for (int i = start; i < candidates.length; i++) {
            int curr = candidates[i];
            if (i != start && curr == candidates[i - 1])
                continue;
            list.add(curr);
            dfs(candidates, target, total + curr, i + 1, res, list);
            list.remove(list.size() - 1);
        }
        
    }
}