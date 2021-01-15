class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> deadendslist = new HashSet<>(Arrays.asList(deadends));
        
        if (deadendslist.contains("0000"))
            return -1;
        
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return level;
                }
                
                List<String> next_locknums = generateNext(curr);
                
                for (String next : next_locknums) {
                    if (visited.contains(next) || deadendslist.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.add(next);
                }
            }
            level++;
        }
        
        return -1;
    }
    
    private List<String> generateNext (String str) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char[] char_arr = str.toCharArray();
            if (char_arr[i] == '0') {
                char_arr[i] = '1';
                list.add(new String(char_arr));
                char_arr[i] = '9';
                list.add(new String(char_arr));
            }
            else if (char_arr[i] == '9') {
                char_arr[i] = '0';
                list.add(new String(char_arr));
                char_arr[i] = '8';
                list.add(new String(char_arr));
            }
            else {
                char_arr[i] += 1;
                list.add(new String(char_arr));
                char_arr[i] -= 2;
                list.add(new String(char_arr));
            }
        }
        
        return list;
    }
}