class StickerToSpellWord {
    public int minStickers(String[] stickers, String target) {
        
        int n = target.length();
        int N = 1 << n;
        
        //dp state means each subset with corresponding index was set either 1 or 0
        int[] dp = new int[N];
        
        //initialization dp[0] is set as 0
        for (int i = 1; i < N; i++)
            dp[i] = -1;
        
        //function
        //loop through each state
        for (int i = 0; i < N; i++) {
            if (dp[i] == -1)
                continue;
             
            //loop through each stick to change current state
            for (String sticker : stickers) {
                //starting state will be i
                int state = i;
                for (char c : sticker.toCharArray()) {
                    //for each character in sticker, check if it can mask a missing char in target
                    for (int j = 0; j < n; j++) {
                        if (target.charAt(j) == c && ((state >> j) & 1) == 0) {
                            state = state | (1 << j);
                            break;
                        }
                    }
                }
                //update state
                if (dp[state] == -1 || dp[state] > dp[i] + 1)
                    dp[state] = dp[i] + 1;
            }
        }
        
        return dp[N - 1];
    }
}