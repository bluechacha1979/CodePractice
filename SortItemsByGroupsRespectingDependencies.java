class Solution {
    private void buildItemGraph(List<List<Integer>> beforeItems, Map<Integer, List<Integer>> itemGraph, int[] itemIndegree) {
        for (int i = 0; i < itemIndegree.length; i++) {
            List<Integer> beforeNums = beforeItems.get(i);
            for (int beforeNum : beforeNums) {
                if (!itemGraph.containsKey(beforeNum)) {
                    itemGraph.put(beforeNum, new ArrayList<>());
                }
                itemGraph.get(beforeNum).add(i);
                itemIndegree[i]++;
            }
        }
    }
    
     private void buildGroupGraph(int[] group,List<List<Integer>> beforeItems, Map<Integer, List<Integer>> groupGraph, int[] groupIndegree) {
         
        for (int i = 0; i < group.length; i++) {
            int toGroup = group[i];
            List<Integer> fromItems = beforeItems.get(i);
            for(int item : fromItems) {
                int fromGroup = group[item];
                if (toGroup != fromGroup) {
                    if (!groupGraph.containsKey(fromGroup)) {
                        groupGraph.put(fromGroup, new ArrayList<>());
                    }
                    groupGraph.get(fromGroup).add(toGroup);
                    groupIndegree[toGroup]++;
                }
            }
        }
    }
    
    private List<Integer> topologicalSort (Map<Integer, List<Integer>> graph, int[] indegree) {
        int n = indegree.length;
        List<Integer> list = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
       for (int key : graph.keySet()) {
          if(indegree[key] == 0) {
            queue.add(key);
          }
        }
        
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            n--;
            list.add(curr);
            for (int next : graph.get(curr)) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        
        return n == 0 ? list : new ArrayList<>();
    }
    
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        
          for (int i=0;i<m;i++) {
              groupGraph.put(i, new ArrayList());      
            }
    
        for (int i=0;i<n;i++) {
          itemGraph.put(i, new ArrayList());
        }
    
        
        int[] groupIndegree = new int[m];
        int[] itemIndegree = new int[n];
        
        buildGroupGraph(group, beforeItems, groupGraph, groupIndegree);
        buildItemGraph(beforeItems, itemGraph, itemIndegree);
            
        List<Integer> groupList = topologicalSort(groupGraph, groupIndegree);
        List<Integer> itemList = topologicalSort(itemGraph, itemIndegree);
        
        if(groupList.size() == 0 || itemList.size() == 0) return new int[0];  
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int item : itemList) {
           if (!map.containsKey(group[item])) {
               map.put(group[item], new ArrayList<>());
           }
           map.get(group[item]).add(item); 
        }
        
        int[] ans = new int[n];
        int idx = 0;
        for (Integer grp : groupList) {
          List <Integer> items = map.getOrDefault(grp, new ArrayList());
          for (Integer item : items) {
            ans[idx++] = item;  
       }      
    }
        
        return ans;
        
    }
}