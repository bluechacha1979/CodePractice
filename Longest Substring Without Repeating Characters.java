class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> next_index = new HashMap<>();
        
        int left = 0;
        int right = 0;
        int maxLen = 0;
        
        while (right < s.length()) {
            char curr = s.charAt(right);
            if (next_index.containsKey(curr)) {
                left = Math.max(left, next_index.get(curr));
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            next_index.put(curr, right + 1);
            right++;
        }
        
        return maxLen;
        
    }
}