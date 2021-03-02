class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board);
    }
    
    private boolean solve(char[][] board) {
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] !='.') {
                    continue;
                }
                
                for (char c = '1'; c <= '9'; c++) {
                    if (isValid(board, i, j ,c)) {
                        board[i][j] = c;
                        if (solve(board))
                            return true;
                        else
                            board[i][j] = '.';
                    } 
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean isValid (char[][] board, int row, int col, char curr) {
        
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == curr)
                return false;
            
            if (board[row][i]!= '.' && board[row][i] == curr)
                return false;
            
            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;
            if (board[r][c] != '.' && board[r][c] == curr)
                return false;
        }
        
        return true;
    }
}