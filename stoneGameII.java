class stoneGameII {
    public int stoneGameII(int[] piles) {
        
        int n = piles.length;
        
        int[][] memo = new int[n][n];
        
        //get presum for who many stones left for each index i
        int[] presum =  Arrays.copyOf(piles, piles.length);
        for (int i = presum.length - 2; i >= 0; i--) presum[i] += presum[i + 1];
        
        return helper(presum, memo, 0, 1);
    }
    
    public int helper(int[] presum, int[][] memo, int start, int M) {
        //if player can take all the remaining piles based on M, return the total remaining stones
        int upper_limit = M * 2;
        if (start + upper_limit >= presum.length)
            return presum[start];
        
        if (memo[start][M] > 0) 
            return memo[start][M];
        
        //for each X that player can take, get the maximum of player's current take - what opponent can take
        int take = 0;
        int res = 0;
        for (int i = 1; i <= upper_limit; i++) {
            take = presum[start] - presum[start + i];
            res = Math.max(res, take + presum[start + i]- helper(presum, memo, start + i, Math.max(M, i)));        
        }
        memo[start][M] = res;
        return res;
    }
}