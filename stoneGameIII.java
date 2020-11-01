class stoneGameIII {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;

        //dp[i] represent maximum score Alice has over Bob starting from position i
        int[] dp = new int[n + 1];

        for (int i = dp.length - 2; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;

            //get the maximum result from take 1 or 2 or 3 stones
            int take = 0;
            for (int j = 0; j < 3; j++) {
                int index = i + j;
                if (i + j >= n)
                    break;
                take = take + stoneValue[index];
                //dp[i] will be the maximum of current take minus what remaining for component
                dp[i] = Math.max(dp[i], take - dp[index + 1]);
            }
        }

        if (dp[0] > 0)
            return "Alice";
        if (dp[0] < 0)
            return "Bob";

        return "Tie";
    }
}