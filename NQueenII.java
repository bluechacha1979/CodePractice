class Solution {
    int count=0;
    public int totalNQueens(int n) {
        int chess[][]=new int[n][n];
        nQueens(chess,0);
        return count;
    }
  
    public void nQueens(int chess[][],int row){
      if(row==chess.length){
        count++;
        return;
      }
      
      for(int col=0;col<chess.length;col++){
        if(isQueenValid(chess,row,col)){
          chess[row][col]=1;
          nQueens(chess,row+1);
          chess[row][col]=0;
        }
      }
      
    }
    public boolean isQueenValid(int chess[][],int row,int col){
      for(int i=row-1,j=col;i>=0;i--){
        if(chess[i][j]==1) return false;
      }

      for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
        if(chess[i][j]==1) return false;
      }

      for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--,j++){
        if(chess[i][j]==1) return false;
      }
      return true;
    }
}