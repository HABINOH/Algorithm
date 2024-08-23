import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int n;
    static Shark babyShark;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        map = new int[n][n];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == 9){
                    babyShark = new Shark(i, j, 2, 0, 0);
                    map[i][j] = 0;
                }
            }
        }

        while (true){
            if(!findShark()){
                break;
            }
        }

        bw.write(String.valueOf(babyShark.dist));
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean findShark() { // 먹을 수 있는 상어 찾기
        Shark target = bfs(); // 가장 가까운 먹이를 찾기
        if (target != null) {
            babyShark.x = target.x;
            babyShark.y = target.y;
            babyShark.dist += target.dist;
            babyShark.eat++;

            if (babyShark.eat == babyShark.size) {
                babyShark.size++;
                babyShark.eat = 0;
            }

            map[babyShark.x][babyShark.y] = 0; // 먹은 물고기 자리 초기화
            return true;
        }
        return false;
    }
    static Shark bfs() {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        visited[babyShark.x][babyShark.y] = true;
        queue.add(new Point(babyShark.x, babyShark.y, 0));

        ArrayList<Shark> candidates = new ArrayList<>();

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (inRange(nx, ny) && !visited[nx][ny] && babyShark.size >= map[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.add(new Point(nx, ny, cur.dis + 1));

                    if (map[nx][ny] > 0 && map[nx][ny] < babyShark.size) {
                        candidates.add(new Shark(nx, ny, map[nx][ny], 0, cur.dis + 1));
                    }
                }
            }
        }

        if (candidates.isEmpty()) {
            return null;
        }

        Collections.sort(candidates);
        return candidates.get(0); // 가장 우선순위 높은 상어를 반환
    }
    static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }

    static class Point {
        int x;
        int y;
        int dis;
        public Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    static class Shark implements Comparable<Shark> {
        int x;
        int y;
        int size;
        int eat;
        int dist;

        public Shark(int x, int y, int size, int eat, int dist) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.eat = eat;
            this.dist = dist;
        }

        @Override
        public int compareTo(Shark other) {
            int distCompare = Integer.compare(this.dist, other.dist);
            if (distCompare != 0) {
                return distCompare;
            }
            int xCompare = Integer.compare(this.x, other.x);
            if (xCompare != 0) {
                return xCompare;
            }
            return Integer.compare(this.y, other.y);
        }
    }
}
