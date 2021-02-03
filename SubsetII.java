class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums);
        
        boolean[] visited = new boolean[nums.length];
        
        dfs(nums, list, res, visited, 0);
        
        return res;
    }
    
    private void dfs(int[]nums, List<Integer> list, List<List<Integer>> res, boolean[] visited, int start){
        if (start <= nums.length) {
            res.add(new ArrayList<>(list));
        }
        
        for (int i = start; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                    continue;
            
            visited[i] = true;
            list.add(nums[i]);
            dfs(nums, list, res, visited, i + 1);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
        
    }
}