class Solution {
    public int snakesAndLadders(int[][] board) {
       int N = board.length;
      
       //record distance for each number 
       Map<Integer, Integer> dist = new HashMap<>();
       dist.put(1, 0);
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        
        int dest = 0;
        while (!queue.isEmpty()) {
            int s = queue.poll();
            if (s == N * N)
                return dist.get(s);
            for (int i = s + 1; i <= Math.min(s + 6, N*N); i++) {
                int n = getNum(i, N);
                int row = n / N;
                int col = n % N;
                if (board[row][col] != -1)
                    dest = board[row][col];
                else
                    dest = i;
                if (!dist.containsKey(dest)){
                    dist.put(dest, dist.get(s) + 1);
                    queue.add(dest);
                }
            }
        }
        return -1;
        
    }
    
    private int getNum(int x, int N) {
        int row = N - 1 - (x - 1) / N;
        
        int col = 0;
        if (row % 2 != N % 2) {
            col = (x - 1) % N;
        }
        else 
            col = N - 1 - (x - 1) % N;
        
        return row * N + col;
    }
}