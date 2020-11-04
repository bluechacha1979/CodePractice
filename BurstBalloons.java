class BurstBalloons {
       public int maxCoins(int[] nums) {
        int[] new_nums = new int[nums.length + 2];
        int n = 1;
        
        for (int x : nums) 
            if (x > 0) new_nums[n++] = x;
        
        new_nums[0] = new_nums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right], new_nums[left] * new_nums[i] * new_nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
}