class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int left = 0;
        int right = 0;
        
        while (right < nums.length) {
             while (!maxDeque.isEmpty() && maxDeque.peekLast() < nums[right])
                maxDeque.pollLast();
             while (!minDeque.isEmpty() && minDeque.peekLast() > nums[right])
                minDeque.pollLast();
            
            maxDeque.addLast(nums[right]);
            minDeque.addLast(nums[right]);
            
            if (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                if (maxDeque.peekFirst() == nums[left])
                    maxDeque.pollFirst();
                if (minDeque.peekFirst() == nums[left])
                    minDeque.pollFirst();
                left++;
            }
            right++;
        }
        
        return right - left;
    }
}