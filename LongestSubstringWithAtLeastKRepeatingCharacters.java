class Solution {
    public int longestSubstring(String s, int k) {
        
        int maxUnique = getUnique(s);
        int maxLen = 0;
    
        for (int i = 1; i <= maxUnique; i++) {
            int left = 0;
            int right = 0;  
            int uniq_cnt = 0;
            int overK = 0;
            int[] unique = new int[26];
            while (right < s.length()) {
                if (uniq_cnt <= i) {
                    char curr = s.charAt(right);
                    if (unique[curr - 'a'] == 0) {
                        uniq_cnt++;
                    }
                    unique[curr - 'a']++;
                    if (unique[curr - 'a'] == k) {
                        overK++;
                    }
                    right++;
                }
                else {
                   char curr = s.charAt(left);
                   if (unique[curr - 'a']== k){
                       overK--;
                   }
                   unique[curr - 'a']--;
                   if (unique[curr - 'a'] == 0) {
                      uniq_cnt--;
                   } 
                  left++;
                }
                
                if (uniq_cnt == i && overK == uniq_cnt) {
                    maxLen = Math.max(maxLen, right - left);
                }
            }
        }
        
        return  maxLen;
    }
    
    private int getUnique (String s) {
        boolean[] map = new boolean[26];
        
        int unique = 0;
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(!map[curr - 'a']) {
                map[curr - 'a'] = true;
                unique++;
            }
        }
        
        return unique;
    }
}