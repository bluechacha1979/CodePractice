class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        boolean[] visited = new boolean[friends.length];
        Map<String, Integer> map = new HashMap<>();
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(id);
        visited[id] = true;
        
        int curr_level = 0;
        while (!queue.isEmpty()) { 
            if (curr_level == level)
                break;
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                for (int friend : friends[curr]) {
                    if (!visited[friend]) {
                        queue.add(friend);
                        visited[friend] = true;
                }
              }
            }
            curr_level++;
        }
        
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            List<String> videos_watched = watchedVideos.get(curr);
            for (String video : videos_watched) {
                if (!map.containsKey(video)) {
                    map.put(video, 1);
                }
                else {
                    map.put(video, map.get(video) + 1);
                }        
            } 
        }
        
        List<String> res = new ArrayList<>(map.keySet());

        res.sort((a, b) -> {
            int fa = map.get(a);
            int fb = map.get(b);
            if (fa != fb) {
                return fa - fb;
            } else {
                return a.compareTo(b);
            }
        });


        return res;
    }
}