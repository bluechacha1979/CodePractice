class minScoreTriangulation {
   public int minScoreTriangulation(int[] A) {
         
         int n = A.length;
         
         //dp[i][j] state represents the maximum triangulation from array index i to array index j;
         int[][] dp = new int[n][n];
         
         //dp function, loop the point between i and j
         //the minimum case start from d = 2 which has 3 points to form a triangle
        //bottom up from d = 2 to top when d = n - 1
         for (int d = 2; d < n; d++) {
             for (int i = 0; i + d < n; i++) {
                 int j = i + d;
                 dp[i][j] = Integer.MAX_VALUE;
                 for (int k = i + 1; k < j; k++) {
                     dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[k] * A[j]);
                 } 
             }
         }
        
        //return value will be dp from array index i = 0 to the last array item index j = n -1
        return dp[0][n - 1];
    }
}