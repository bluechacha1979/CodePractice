class Solution {
    public List<List<String>> partition(String s) {
             List<List<String>> res = new ArrayList<>();   
        
        if (s == null || s.length() == 0)
            return res;
        
        List<String> list = new ArrayList<>();
        
        dfs(s, list, res);
             
        return res;
    }
    
    public void dfs (String s, List<String> list, List<List<String>> res) {
        if (s.length() == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(0, i + 1);
            if (isPanlindrome(str)) {
                list.add(str);
                dfs(s.substring(i + 1), list, res);
                list.remove(list.size() - 1);
            }
        }
            
    }
    
    private boolean isPanlindrome (String str) {
        int left = 0;
        int right = str.length() - 1;
        
        while (left <= right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
}