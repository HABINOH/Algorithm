import java.io.*;
import java.util.*;

public class Main {
    static class Point implements Comparable<Point>{
        int x;
        int y;
        int dir;
        int mirrors;
//        Point parent;
        public Point(int x, int y, int dir, int mirrors){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.mirrors = mirrors;
//            this.parent = parent;
        }
        public int compareTo(Point point){
            return this.mirrors - point.mirrors;
        }
    }
    static int[][] map;
    static Point[] arrive;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int w, h;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        w = Integer.parseInt(stk.nextToken());
        h = Integer.parseInt(stk.nextToken());

        int idx = 0;
        arrive = new Point[2];
        map = new int[h][w];
        for(int i=0;i<h;i++){
            String str = br.readLine();
            for(int j=0;j<w;j++){
                char ch = str.charAt(j);
                if(ch == '.'){map[i][j] = 0;}
                else if(ch == '*'){map[i][j] = 1;}
                else if(ch == 'C'){
                    map[i][j] = 2;
//                    arrive[idx++] = new Point(i,j,-1, 0,null);
                    arrive[idx++] = new Point(i,j,-1, 0);
                }
            }
        }

        answer = Integer.MAX_VALUE - 1;
        bfs();

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(){
        PriorityQueue<Point> queue = new PriorityQueue<>();
        int[][][] visited = new int[h][w][4]; // 위치 방향 거울 설치 횟수 저장
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        queue.add(arrive[0]);
        for(int i=0;i<4;i++){
            visited[arrive[0].x][arrive[0].y][i] = 0;
        }

        while(!queue.isEmpty()){
            Point cur = queue.poll();

            if(cur.x == arrive[1].x && cur.y == arrive[1].y){ //도착
//                List<Point> paths = new ArrayList<>();
//                Point p = cur;
//                while(p != null){
//                    paths.add(p);
//                    p = p.parent;
//                }
//                Collections.reverse(paths);
//                for(Point point : paths){
//                    System.out.println("(" + point.x + ", " + point.y + ")");
//                }
                answer = Math.min(answer, cur.mirrors);
                continue;
            }

            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(inRange(nx, ny) && map[nx][ny] != 1){
                    //시작점 모든 방향 허용 && 레이저 반대 방향 이동 X
                    if(cur.dir == -1 || Math.abs(cur.dir - i) != 2){
                        int mirror = cur.mirrors;
                        if(cur.dir != -1 && cur.dir != i){ //방향이 바뀌면 거울 설치
                            mirror++;
                        }
                        if(visited[nx][ny][i] > mirror){ //더 적은 거울로 갈 수 있는 경우만 이동
                            visited[nx][ny][i] = mirror;
//                        queue.add(new Point(nx, ny, i, mirror, cur));
                            queue.add(new Point(nx, ny, i, mirror));
                        }
                    }
                }
            }
        }
    }
    static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<h && y<w;
    }
}