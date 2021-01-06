class Solution {
    public int shortestSubarray(int[] A, int K) {
        int[] presum = new int[A.length + 1];
        
        for (int i = 1; i <= A.length; i++) {
            presum[i] += presum[i - 1] + A[i - 1];
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        int right = 0;
        int res = Integer.MAX_VALUE;
        while (right <= A.length) {
            
            while (!deque.isEmpty() && presum[right] - presum[deque.peekFirst()] >= K) {
                res = Math.min(res, right - deque.pollFirst());
            }
            
            while (!deque.isEmpty() && presum[right] <= presum[deque.peekLast()]) {
                deque.pollLast();
            }
            
            deque.addLast(right);
            right++;
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}