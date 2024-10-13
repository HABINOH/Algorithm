import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int r, c;
    static Queue<Point> waterQueue = new LinkedList<>();
    static Queue<Point> beaverQueue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = chars[j];
                if (map[i][j] == '*') {
                    waterQueue.add(new Point(i, j));
                    visited[i][j] = true;
                }
                if (map[i][j] == 'S') {
                    beaverQueue.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int answer = bfs();
        bw.write(answer == -1 ? "KAKTUS" : String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs() {
        int time = 0;
        while (!beaverQueue.isEmpty()) {
            // 1. 물 먼저 이동
            int waterSize = waterQueue.size();
            for (int i = 0; i < waterSize; i++) {
                Point cur = waterQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (inRange(nx, ny) && (map[nx][ny] == '.' || map[nx][ny] == 'S')) {
                        map[nx][ny] = '*'; // 물 확장
                        waterQueue.add(new Point(nx, ny));
                    }
                }
            }

            // 2. 비버 이동
            int beaverSize = beaverQueue.size();
            for (int i = 0; i < beaverSize; i++) {
                Point cur = beaverQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (inRange(nx, ny)) {
                        if (map[nx][ny] == 'D') {
                            return time + 1; // 비버가 목적지 도달
                        }
                        if (map[nx][ny] == '.' && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            map[nx][ny] = 'S'; // 비버 이동
                            beaverQueue.add(new Point(nx, ny));
                        }
                    }
                }
            }
            time++;
        }
        return -1; // 도착 불가능
    }

    static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }
}
