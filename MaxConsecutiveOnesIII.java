class Solution {
    public int longestOnes(int[] A, int K) {
        
        int left = 0;
        int right = 0;
        
        //minimum window size set as 0
        int max = 0;
        
        while (right < A.length) {
            //update K for right pointer
            if (A[right] == 0)
                K--;
            
           //when K < 0 record current max window size
            if (K < 0)
                max = Math.max(max, right - left);
            
            //move left pointer only until extra 0 is removed
            while (K < 0) {
                if (A[left] == 0)
                    K++;
                left++;
            }    
            right++;
        }
        
        //return the max of either previous max window size or current window size
        return Math.max(max, right - left);
     }
}