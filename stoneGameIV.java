class StoneGameIV {
    public boolean winnerSquareGame(int n) {
        
        boolean[] dp = new boolean[n + 1];
        
        dp[0] = false;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int take = j * j;
                int remaining = i - take;
                dp[i] = dp[i] || !dp[remaining];
                if (dp[i])
                    break;
            }
        }
        
        return dp[n];
    }
}