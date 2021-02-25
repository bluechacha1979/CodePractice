class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<>();
        
        dfs(S.toCharArray(), res, 0);
        
        return res;
    }
    
    private void dfs(char[] arr, List<String> res, int start) {
        if (start == arr.length) {
            res.add(new String(arr));
        }
        else {
            if (Character.isLetter(arr[start])) {
                arr[start] = Character.toUpperCase(arr[start]);
                dfs(arr, res, start + 1);
                arr[start] = Character.toLowerCase(arr[start]);
                dfs(arr, res, start + 1);
            }
            else {
                dfs(arr, res, start + 1);
            }
        }
    }
}