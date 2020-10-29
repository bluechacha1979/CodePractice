class Solution {
    public boolean stoneGame(int[] piles) {

        int n = piles.length;

        //dp definition: dp[i][j] represents the biggest stones you can win over opponents over
        //piles[i] to piles[j];
        int[][] dp = new int[n][n];

        //initialization
        for (int i = 0; i < n; i++)
            dp[i][i] = piles[i];

        //if take pile i, opponent take dp[i+1][j]
        //if take pile j, opponent take dp[i][j-1]
        for (int size = 1; size < n; size++) {
            for (int i = 0; i + size < n; i++) {
                int j = i + size;
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }

        //return dp[0][n-1] representing the biggest stone from piles[0] to piles[n-1]
        return dp[0][n - 1] > 0;
    }
}