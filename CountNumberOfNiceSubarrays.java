class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0)
                cnt++;
            if(map.containsKey(cnt - k))
                ans += map.get(cnt - k);
            
            if (!map.containsKey(cnt))
                map.put(cnt, 1);
            else
                map.put(cnt, map.get(cnt) + 1);
        }
        
        return ans;
    }
}