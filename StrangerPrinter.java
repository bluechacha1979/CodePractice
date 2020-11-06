class StrangerPrinter {
    public int strangePrinter(String s) {
         if (s == null || s.length() == 0) {
            return 0;
        }
        
        int n = s.length();
        
        //dp definition, dp[i][j] represents the minimum number of turns from
        //index i to index j
        int[][] dp = new int[n][n];
        
        
        //initialize dp for neighoring character
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1))
                dp[i][i + 1] = 1;
            else if (i + 1 < s.length() && s.charAt(i) != s.charAt(i + 1))
                dp[i][i + 1] = 2;
        }
        
        //dp function
        for (int d = 2; d < n; d++) {
            for (int i = 0; i + d < n; i++) {
                int j = i + d;
                dp[i][j] = d + 1;
                for (int k = i; k < j; k++) {
                    if (s.charAt(k) != s.charAt(k + 1))
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    else
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] - 1);
                }
            }
        }
    
        //return value is dp from index 0 to the last index of input s
        return dp[0][n - 1];
    }
}