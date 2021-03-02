class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[][] chess = new int[n][n];
        List<List<String>> res = new ArrayList<>();
        List<String> list = new ArrayList<>();
        
        dfs(res, list, chess, 0);
        
        return res;
    }
    
    private void dfs(List<List<String>> res, List<String> list, int[][] chess, int row) {
        if (row == chess.length) {
            res.add(new ArrayList(list));
            return;
        }
        
        for (int j = 0; j < chess[0].length; j++) {
            
            if (isValid(chess, row, j)) {
                chess[row][j] = 1;
                char[] arr = new char[chess.length];
                Arrays.fill(arr, '.');
                arr[j] = 'Q';
                list.add(new String(arr));
                dfs(res, list, chess, row + 1);
                list.remove(list.size() - 1);
                chess[row][j] = 0;
            }
        }
    }
    
    private boolean isValid(int[][] chess, int row, int col) {
        for (int i = row - 1; i >= 0; i--) {
            if (chess[i][col] == 1)
                return false;
        }
        
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1)
                return false;
        }
        
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess[0].length; i--, j++) {
            if (chess[i][j] == 1)
                return false;
        }
        
        return true;
    }
}