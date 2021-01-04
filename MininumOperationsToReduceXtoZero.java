class Solution {
    public int minOperations(int[] nums, int x) {
        int target = 0;
        
        for (int num : nums)
            target += num;
        
        int left = 0;
        int right = 0;
        
        int sum = 0;
        int max = -1;
        while (right < nums.length) {
            sum += nums[right];
            
            while (sum > target - x && left <= right) {
                sum -= nums[left++];
            }
            
            if (sum == target - x) {
                max = Math.max(max, right - left + 1);
            }
            right++;
        }
        
        return max == -1? -1 : nums.length - max;
    }
}