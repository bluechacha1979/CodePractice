class SmallestSufficientTeam{
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
        int n = req_skills.length;
        int N = 1 << n;
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) 
            map.put(req_skills[i], i);
        
        //dp definition dp[i] represents for each state
        List<Integer>[] dp = new ArrayList[N];
        dp[0] = new ArrayList<>();
        
        //dp function
        for (int i = 0; i < people.size(); i++) {
            //reset the starting state for each people
            int curr = 0; 
             //loop through each people's skill
             for (String s : people.get(i)) {
                curr = curr | 1 << map.get(s);
             }      
             //combine with other skills and see if we need less people
             for (int j = 0; j< N; j++) {
                if (dp[j] == null) 
                    continue;
                int comb = j | curr;
                if (dp[comb] == null || dp[j].size() + 1 < dp[comb].size()) {
                    dp[comb]= new ArrayList<>(dp[j]);
                    dp[comb].add(i);
                }
            }
         }
        
        List<Integer> res = dp[N - 1];
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; ++i) 
            arr[i] = res.get(i);
        return arr;
        
    }
}