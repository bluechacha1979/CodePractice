class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> outDegree = new HashMap<>();
        
        //get indegree and out degree
        for (int[] prerequisite : prerequisites) {
            int course1 = prerequisite[0];
            int course2 = prerequisite[1];
            
            inDegree[course1]++;
                       
            if (!outDegree.containsKey(course2)) {
                outDegree.put(course2, new ArrayList<>());
            }
            outDegree.get(course2).add(course1);
        }
        
        //put indegree 0 in queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        
        int[] res = new int[numCourses];
        int count = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[count++] = curr; 
            if (outDegree.containsKey(curr)){

                for (int next_course : outDegree.get(curr)) {
                    inDegree[next_course]--;
                    if (inDegree[next_course] == 0) {
                        queue.add(next_course);
                    }
                }
            }
        }
        
        if (count != numCourses)
            return new int[]{};
        
        return res;
    }
}