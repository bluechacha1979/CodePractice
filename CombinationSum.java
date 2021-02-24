class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(candidates);
        
        dfs(candidates, target, list, res, 0, 0);
        
        return res;
    }
    
    private void dfs(int[] candidates, int target, List<Integer> list, List<List<Integer>> res, int sum, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            res.add(new ArrayList(list));
            return;
        }
        
        for (int i = start; i < candidates.length; i++){
            list.add(candidates[i]);
            dfs(candidates, target, list, res, sum + candidates[i], i);
            list.remove(list.size() - 1);
        }
    }
}