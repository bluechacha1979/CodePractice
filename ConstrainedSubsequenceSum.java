class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        Deque<Integer> maxDeque = new LinkedList<>();
        
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int max = Math.max(0, maxDeque.isEmpty()? 0 : nums[maxDeque.peekFirst()]);
            nums[i] += max;
            res = Math.max(res, nums[i]);
            
            while(!maxDeque.isEmpty() && nums[i] >= nums[maxDeque.peekLast()]) {
                maxDeque.pollLast();
            }
            
            maxDeque.addLast(i);
            
            if (i - maxDeque.peekFirst() + 1 > k) {
                maxDeque.pollFirst();
            }
        }
        
        return res;
    }
}