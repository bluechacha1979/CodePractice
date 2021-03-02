class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        
        dfs(word, res, sb, 0, 0);
        
        return res;
    }
    
    private void dfs(String word, List<String> res, StringBuilder sb, int k, int count) {
        if (count == word.length()) {
            if (k > 0) {
                sb.append(k);
            }
            res.add(sb.toString());
            return;
        }
        
        int len = sb.length();
        
        //take the current character
        if (k > 0) {
            sb.append(k);
        }
        sb.append(word.charAt(count));
        dfs(word, res, sb, 0, count + 1);
        
        //backtrack
        sb.setLength(len);
        dfs(word, res, sb, k + 1, count + 1);
    }
}