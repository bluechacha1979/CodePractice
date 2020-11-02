class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        
        //dp[i] represent the maximum amount robbed from 1st house to ith house
        int[] dp = new int[nums.length + 1];
        
        //initialize dp[i] equal to the amount of first house
        dp[1] = nums[0];
        
        
        //for each ith house, it will the maximum of amount between two conditions
        //either the last house is robbed or last house is not robbed.
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i - 1], dp[i - 1]);
        }
        
        return dp[nums.length];
    }
}