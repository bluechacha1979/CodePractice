class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList == null || secondList == null)
            return new int[][]{};
        
        List<int[]> res = new ArrayList<>();
        
        int first_ptr =  0;
        int second_ptr  = 0;
        
        while (first_ptr < firstList.length && second_ptr < secondList.length) {
            int low = Math.max(firstList[first_ptr][0], secondList[second_ptr][0]);
            int high = Math.min(firstList[first_ptr][1], secondList[second_ptr][1]);
            
            if (low <= high) {
                res.add(new int[]{low, high});
            }
            
            if (firstList[first_ptr][1] < secondList[second_ptr][1]) {
                first_ptr++;
            }
            else {
                second_ptr++;
            }
        }
        
        int[][] ans = new int[res.size()][2];
        
        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = res.get(i)[0];
            ans[i][1] = res.get(i)[1];
        }
        
        return ans;
    }
}