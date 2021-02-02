class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();
        
        dfs(nums, res, list, 0);
        
        return res;
    }
    
    private void dfs (int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        if (list.size() <= nums.length) {
            res.add(new ArrayList(list));
        }
        
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}