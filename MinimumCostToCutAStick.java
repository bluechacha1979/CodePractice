class MinimumCostToCutAStick {
       public int minCost(int n, int[] cuts) {
        if (cuts == null || cuts.length == 0)
            return 0;
        
        int cut_nums = cuts.length;
        
        //sort the cuts 
        Arrays.sort(cuts);
        
        //adding the starting and ending point to the cuts;
        int[] new_cuts = new int[cut_nums + 2];
        for (int i = 1; i < new_cuts.length - 1; i++)
            new_cuts[i] = cuts[i - 1];
        new_cuts[0] = 0;
        new_cuts[new_cuts.length - 1] = n;
        
        //dp definition dp[i][j] represents the mininum cost of the cut from cut point i to cut point j
        //initialize the dp, depth 1 dp will be set as 0, all other dp will be set as Integer Max Value
        int[][] dp = new int[cut_nums + 2][cut_nums + 2];
        for (int[] row : dp) 
            Arrays.fill(row, Integer.MAX_VALUE); 
        for (int i = 0; i < new_cuts.length - 1; i++) 
            dp[i][i + 1] = 0;
        
        //dp function slice the stick to smaller stick
        for (int d = 2; d < new_cuts.length; d++) {
            for (int i = 0; i + d < new_cuts.length; i++) {
                int j = i + d;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + new_cuts[j] - new_cuts[i]);
                }
            }
            
        }
        
        return dp[0][new_cuts.length - 1];
    }
}