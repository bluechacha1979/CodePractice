class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        int left = 0;
        int right = 0;
        int max = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        while (right < s.length()) {
            char curr = s.charAt(right);
            
            //add curr character's rightmost position to map
            map.put(curr, right);
     
            //expand right pointer when the current window is still desirable
            //move left pointer when the current window is not desirable
            if (map.size() > k) {
                int del_indx = Collections.min(map.values());
                left = del_indx + 1;
                map.remove(s.charAt(del_indx));
            }
            
            max = Math.max(max, right - left + 1);
            right++;
        }
        
        return max;
    }
}