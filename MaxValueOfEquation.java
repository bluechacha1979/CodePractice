class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        
        int left = 0;
        int right = 1;
        int ans = Integer.MIN_VALUE;
        
        while (right < points.length) {
            while (!deque.isEmpty() && points[right][0] - points[deque.peekFirst()][0] > k) {
                deque.pollFirst();
            }
            
            if (!deque.isEmpty()) {
                left = deque.peekFirst();
                int temp = points[right][1] + points[left][1] + points[right][0] - points[left][0];
                ans = Math.max(temp, ans);
            }
            
            while (!deque.isEmpty() && points[right][1] - points[right][0] >= points[deque.peekLast()][1] - points[deque.peekLast()][0])
                deque.pollLast();
           
            deque.addLast(right);
            right++;
        }
        
        return ans;
    }
 
}