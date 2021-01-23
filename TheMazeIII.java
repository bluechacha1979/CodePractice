class Solution {
    class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;
        String path;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            dist = Integer.MAX_VALUE;
            path = "";
        }
        
        public Point(int x, int y, int dist, String path) {
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.path = path;
        }
        
        public int compareTo (Point p) {
            if (this.dist == p.dist) {
                return this.path.compareTo(p.path);
            }
            
            return this.dist - p.dist;
        }
        
    }

    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length;
        int n = maze[0].length;
        Point[][] points=new Point[m][n];
        for (int i = 0;i < m*n;i++) 
            points[i / n][i % n]=new Point(i / n, i % n);        
       int[] dx = new int[] {0, 0, 1, -1};
       int[] dy = new int[] {1, -1, 0, 0};
       String[] ddir = new String[] {"r", "l", "d", "u"};
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(ball[0], ball[1], 0, ""));
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            if (points[curr.x][curr.y].compareTo(curr) <= 0) 
                continue;
            points[curr.x][curr.y] = curr;
            for (int i = 0; i < 4; i++) {   
                int xx = curr.x;
                int yy = curr.y;
                int dist = curr.dist;
                while (xx >= 0 && xx < maze.length && yy >=0 && yy < maze[0].length && maze[xx][yy]==0 && (xx!=hole[0] || yy!=hole[1])) {
                    xx += dx[i];
                    yy += dy[i];
                    dist++;
                }        
                if (xx != hole[0] || yy != hole[1]) {
                    xx -= dx[i];
                    yy -= dy[i];
                    dist--;
                }
                queue.add(new Point(xx, yy, dist, curr.path + ddir[i]));
            }   
        }   
         return points[hole[0]][hole[1]].dist==Integer.MAX_VALUE?"impossible":points[hole[0]][hole[1]].path;
    }
}