import java.util.*;
import java.io.*;

public class Main {
    static class Point {
        int x;
        int y;
        int time;
        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        Queue<Point> jihun = new LinkedList<>();
        Queue<Point> fire = new LinkedList<>();
        int[][] fireBoard = new int[r][c];
        int[][] jihunBoard = new int[r][c];
        char[][] map = new char[r][c];

        for (int i = 0; i < r; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                map[i][j] = chars[j];
                if (chars[j] == '#') {
                    fireBoard[i][j] = -1;
                    jihunBoard[i][j] = -1;
                } else if (chars[j] == 'J') {
                    jihunBoard[i][j] = 1;
                    jihun.add(new Point(i, j, 1));
                } else if (chars[j] == 'F') {
                    fireBoard[i][j] = 1;
                    fire.add(new Point(i, j, 1));
                }
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        // Fire BFS
        while (!fire.isEmpty()) {
            Point cur = fire.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (inRange(nx, ny, r, c) && fireBoard[nx][ny] == 0 && map[nx][ny] == '.') {
                    fire.add(new Point(nx, ny, cur.time + 1));
                    fireBoard[nx][ny] = cur.time + 1;
                }
            }
        }

        // Jihun BFS
        int answer = -1;
        while (!jihun.isEmpty()) {
            Point cur = jihun.poll();
            if (cur.x == 0 || cur.y == 0 || cur.x == r - 1 || cur.y == c - 1) {
                answer = cur.time;
                break; // 탈출 지점 발견 시 바로 종료
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (inRange(nx, ny, r, c) && jihunBoard[nx][ny] == 0 && map[nx][ny] == '.') {
                    if (fireBoard[nx][ny] == 0 || cur.time + 1 < fireBoard[nx][ny]) {
                        jihun.add(new Point(nx, ny, cur.time + 1));
                        jihunBoard[nx][ny] = cur.time + 1;
                    }
                }
            }
        }

        if (answer == -1) {
            bw.write("IMPOSSIBLE");
        } else {
            bw.write(String.valueOf(answer));
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean inRange(int x, int y, int r, int c) {
        return x >= 0 && y >= 0 && x < r && y < c;
    }
}
