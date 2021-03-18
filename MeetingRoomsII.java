class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        
        for (int[] meeting : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.add(meeting[1]);
            }
            else {
                if (meeting[0] >= minHeap.peek()) {
                    minHeap.poll();
                }
                minHeap.add(meeting[1]);
            }
        }
        
        return minHeap.size();
    }
}