class Solution {

    Map<String, List<String>> map = new HashMap<>();
    
    public List<String> wordBreak(String s, List<String> wordDict) {   
        Set<String> dict = new HashSet<>(wordDict);
        List<String> res= new ArrayList<>();
        
        if (map.containsKey(s))
            return map.get(s);
        
        if (dict.contains(s))
            res.add(s);
        
        for (int i = 1; i < s.length(); i++) {
            String next = s.substring(i);
            if (dict.contains(next)) {
                List<String> temp = wordBreak(s.substring(0, i), wordDict);
                if (temp.size() > 0) {
                    for (String str : temp) {
                        res.add(str + " " + next);
                    }
                }
            }
        }
        
        map.put(s, res);
        
        return res;
    }
}