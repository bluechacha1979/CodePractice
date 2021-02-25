class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        dfs(n, sb, res, 0, 0);
        
        return res;
    }
    
    private void dfs (int n, StringBuilder sb, List<String> res, int openBrackets, int closeBrackets) {
        if (openBrackets > n || closeBrackets > openBrackets)
            return;
        
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }
        
        sb.append("(");
        dfs(n, sb, res, openBrackets + 1, closeBrackets);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        dfs(n, sb, res, openBrackets, closeBrackets + 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}