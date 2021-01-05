class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < n; right++) {
            char curr = s.charAt(right);
            
            if (map.containsKey(curr)) {
                map.put(curr, map.get(curr) + 1);
            }
            
            Map<Character, Integer> temp = new HashMap<>();
            temp.put('a', map.get('a'));
            temp.put('e', map.get('e'));
            temp.put('i', map.get('i'));
            temp.put('o', map.get('o'));
            temp.put('u', map.get('u'));
            
            while (temp.get('a') % 2 != 0 || temp.get('e') % 2 != 0 || temp.get('i') % 2 != 0 || temp.get('o') % 2 != 0 || temp.get('u') % 2 != 0) {
                char left_c = s.charAt(left);
                if (temp.containsKey(left_c)) {
                    temp.put(left_c, temp.get(left_c) - 1);
                }
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            left = 0;
        }
        
        return maxLen;
    }
}