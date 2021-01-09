class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int res = 0;
        
        int left = 0, right = 0;
        int n = s.length();
        
        while (right < s.length()) {
            char right_c = s.charAt(right);
            count[right_c - 'a']++;
            
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += n - right;
                char left_c = s.charAt(left);
                count[left_c - 'a']--;
                left++;
            }     
            right++;
        }
        return res;
    }
}