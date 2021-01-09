class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        return sumAtMost(A, S) - sumAtMost(A, S - 1); 
    }
    
    private int sumAtMost (int[] A, int s) {
        int left = 0, right = 0, sum = 0, res = 0;
        
        while (right < A.length) {
            sum += A[right];
            
            while (sum > s && left <= right) {
                sum -= A[left];
                left++;
            }
            
            res += right - left + 1;
            right++;
        }
        
        return res;
    }
}