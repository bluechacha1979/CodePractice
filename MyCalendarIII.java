class MyCalendarThree {
    TreeMap<Integer, Integer> calendar;
    
    public MyCalendarThree() {
        calendar = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        calendar.put(start, calendar.getOrDefault(start, 0) + 1);
        calendar.put(end, calendar.getOrDefault(end, 0) - 1);
        
        int ans = 0; 
        int max  = 0;
        
        for (int val : calendar.values()) {
            ans +=  val;
            if (ans > max) {
                max =  ans;
            }
        }
        
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */