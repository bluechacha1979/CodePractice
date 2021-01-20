class Solution {
    public int minFlips(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        String start = convertToString(mat);
        String target = convertToString(new int[m][n]);
        queue.add(start);
        visited.add(start);
        
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                String curr = queue.poll();
                if (curr.equals(target))
                    return level;
                int[][] matrix = convertToMatrix(curr, m, n);
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        flip(matrix, i, j);
                        String temp = convertToString(matrix);
                        flip(matrix, i, j);
                        if (visited.contains(temp))
                            continue;
                        visited.add(temp);
                        queue.add(temp);
                        
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    private String convertToString(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j]);
            }
        }
        return sb.toString();
    }
    
    private int[][] convertToMatrix(String str, int m, int n) {
        int[][] matrix = new int[m][n];
        
        for (int i = 0; i < str.length(); i++) {
            int row = i / n;
            int col = i % n;
            matrix[row][col] = str.charAt(i) - '0';
        }
        
        return matrix;
    }
    
    private void flip(int[][] matrix, int x, int y) {
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        
        matrix[x][y] ^= 1;
        
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            
            if (next_x < 0 || next_x > matrix.length - 1 || next_y < 0 || next_y > matrix[0].length - 1)
                continue;
            matrix[next_x][next_y] ^= 1;
        }
    }
}