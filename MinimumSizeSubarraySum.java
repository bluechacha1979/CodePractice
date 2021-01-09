class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int left = 0;
        int right = 0;
        
        int ans = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            
            while (sum >= s) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left++];
            }
            
            right++;
        }
        
        return ans == Integer.MAX_VALUE? 0 : ans;
    }
}