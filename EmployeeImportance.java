class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        
        Queue<Employee> queue = new LinkedList<>();
        queue.add(map.get(id));
        int value = 0;
        
        while (!queue.isEmpty()) {
            Employee curr = queue.poll();
            value += curr.importance;
            
            for (int subordinate : curr.subordinates) {
                queue.add(map.get(subordinate));
            }
        }
        
        return value;
        
    }
}