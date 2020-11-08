class PalindromeRemoval {
    public int minimumMoves(int[] arr) {
        
        if (arr == null || arr.length == 0)
            return 0;
        
        //dp state: dp[i][j] represents miminum number of moves from index i to index j
        int n = arr.length;
        int[][] dp = new int[n][n];
        
        //dp inintial
        for (int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        //function
        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                if (arr[i] == arr[j]){
                      if (i + 1 <= j - 1 )
                        dp[i][j] = dp[i + 1][j - 1];
                      else
                         dp[i][j] = 1;
                    }
                    for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);       
                }     
            }
        }
        
        return dp[0][n - 1];
    }
}