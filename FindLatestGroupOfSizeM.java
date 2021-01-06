class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        
        if (n == m)
            return n;
        
        TreeSet<Integer> wall = new TreeSet<>();
        wall.add(0);
        wall.add(n + 1);
        
        for (int i = n - 1; i >= 0; i--) {
            int left = wall.floor(arr[i]);
            int right = wall.ceiling(arr[i]);
            
            if (arr[i] - left - 1 == m || right - arr[i] - 1 == m)
                return i;
            
            wall.add(arr[i]);
        }
        
        return -1;
    }
}