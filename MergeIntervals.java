class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> res = new ArrayList<>();
        int[] temp = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (temp[1] < intervals[i][0]) {
                res.add(new int[]{temp[0], temp[1]});
                temp = intervals[i];
            }
            
            else {
                temp = new int[]{Math.min(temp[0], intervals[i][0]), Math.max(temp[1], intervals[i][1])};
            }
        }
        res.add(temp);
        
        int[][] ans = new int[res.size()][2];
        int i = 0;
        for (int[] pair : res)
            ans[i++] = pair;
        
        return ans;
    }
}