class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> next = new HashMap<>();
        Map<Integer, Integer> indegree = new HashMap<>();
        
        //build neighbors
        for (int[] prerequisite : prerequisites) {
            int nextcourse = prerequisite[0];
            int precourse = prerequisite[1];
            if (!next.containsKey(precourse))
                next.put(precourse, new ArrayList<>());
            next.get(precourse).add(nextcourse);
            if (!indegree.containsKey(nextcourse))
                indegree.put(nextcourse, 1);
            else
                indegree.put(nextcourse, indegree.get(nextcourse) + 1);
        }
        
        //find courses that has no prerequisite and add to queue
        Queue<Integer> toTake = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (!indegree.containsKey(i))
                toTake.add(i);
        }
        
        int taken = 0;
        while (!toTake.isEmpty()) {
            int course = toTake.poll();
            taken++;
            List<Integer> nextCourses = next.get(course);
            if (nextCourses != null){
                for (int nextCourse : nextCourses) {
                    indegree.put(nextCourse, indegree.get(nextCourse) - 1);
                    if (indegree.get(nextCourse) == 0)
                        toTake.add(nextCourse);
                }
            }
        }
        
        return taken == numCourses;
    }
}