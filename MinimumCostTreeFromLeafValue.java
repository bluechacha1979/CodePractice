class MinimumCostTreeFromLeafValue {
    public int mctFromLeafValues(int[] arr) {     
        if (arr == null || arr.length == 0)
            return 0;
        
        //dp definition, dp[i][j] represents the minimun sum of non-leaf value
        //from index i to index j
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i + 1 < n; i++) {
            dp[i][i + 1] = arr[i] * arr[i + 1];
        }   
        //max arr to keep track the maximum value from index i to index j
        int[][] max = new int[n][n];
        for (int[] row : max) {
            Arrays.fill(row, Integer.MIN_VALUE);    
        }
        for (int i = 0; i < n; i++) {
            max[i][i] = arr[i];
        }
        
        //dp function for tracking the max value
        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                for (int k = i; k < j; k++) {
                    max[i][j] = Math.max(max[i][j], Math.max(max[i][k], max[k + 1][j]));
                }
            }
        }
        //dp function for tracking minimun sum of non-leaf value
        for (int d = 1; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                for (int k = i; k < j; k++) {
                    int temp = dp[i][j];
                    if (temp == 0)
                        dp[i][j] = dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j];
                    else
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                }
            }
        }
        //return value
        return dp[0][n - 1];
    }
}