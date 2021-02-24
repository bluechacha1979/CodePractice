class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        
        dfs(nums, list, res, visited);
        
        return res;
    }
    
    private void dfs(int[] nums, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if(list.size() == nums.length) {
            res.add(new ArrayList(list));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            dfs(nums, list, res, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}