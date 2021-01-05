class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0;
        int right = 0;
        
        int maxLen = 0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        while (right < s.length()) {
            char rc = s.charAt(right);
            
            if (!map.containsKey(rc)){
                map.put(rc, 1);
            }
            else {
                map.put(rc, map.get(rc) + 1);
            }
            
            while (map.size() > 2) {
                char lc = s.charAt(left);
                if (map.get(lc) == 1) {
                    map.remove(lc);
                }
                else {
                    map.put(lc, map.get(lc) - 1);
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            right++;    
        }
        
        return maxLen;
    }
}