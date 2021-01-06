class Solution {
    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(0);
        
        for (int i = 1; i < nums.length; i++) {
            while (deque.peekFirst() != null && deque.peekFirst() < i - k) {
                deque.pollFirst();
            }
            
            dp[i] = nums[i] + dp[deque.peekFirst()];
            
            while (deque.peekLast() != null && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            
            deque.addLast(i);
        }
        
        return dp[nums.length - 1];
        
    }
}