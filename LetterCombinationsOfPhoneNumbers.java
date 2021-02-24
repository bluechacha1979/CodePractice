class Solution {
    private static Map<Character, String> map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();     
        if (digits == null || digits.length() == 0)
            return res;  
        StringBuilder sb = new StringBuilder();   
        dfs(digits, res, sb, 0);
        
        return res;
    }
    
    private void dfs (String digits, List<String> res, StringBuilder sb, int start) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
       
        char curr = digits.charAt(start);
        String mapping = map.get(curr);
        
        for (int i = 0; i < mapping.length(); i++) {
            sb.append(mapping.charAt(i));
            dfs (digits, res, sb, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}