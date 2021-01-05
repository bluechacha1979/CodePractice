class Solution {
    public int subarraysWithKDistinct(int[] A, int K) {
        
        return atMostK(A, K) - atMostK(A, K - 1);
    }
    
    private int atMostK(int[] A, int K) {
        int left = 0;
        int right = 0;
        int res = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        while (right < A.length) {
            int curr = A[right];
            
            if (!map.containsKey(curr) || map.get(curr) == 0) {
                map.put(curr, 1);
                K--;
            }
            else {
                map.put(curr, map.get(curr) + 1);
            }
            
            while (K < 0) {
                int left_num = A[left];
                map.put(left_num, map.get(left_num) - 1);
                if (map.get(left_num) == 0) {
                    K++;
                }
                left++;
            }
            
            res += right - left + 1;
            right++;
        }
        
        return res;
    }
}