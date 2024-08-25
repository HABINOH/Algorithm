import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] map;
    static ArrayList<Cloud> clouds = new ArrayList<>();
    static int[] dx = {0,0,-1,-1,-1,0,1,1,1};
    static int[] dy = {0,-1,-1,0,1,1,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        map = new int[n][n];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        clouds.add(new Cloud(n-1, 0));
        clouds.add(new Cloud(n-1, 1));
        clouds.add(new Cloud(n-2, 0));
        clouds.add(new Cloud(n-2, 1));

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());

            cloudMove(dir, dist);
            addCloudWater();
            createCloud();
        }

        bw.write(String.valueOf(cal()));
        bw.flush();
        bw.close();
        br.close();
    }
    static int cal(){
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result += map[i][j];
            }
        }
        return result;
    }
    static void createCloud() {
        ArrayList<Cloud> newClouds = new ArrayList<>();
        boolean[][] visited = new boolean[n][n]; // 방문 여부 초기화

        for (Cloud cloud : clouds) {
            visited[cloud.x][cloud.y] = true; // 이전 구름 위치를 방문 처리
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] >= 2 && !visited[i][j]) {
                    newClouds.add(new Cloud(i, j));
                    map[i][j] -= 2;
                }
            }
        }
        clouds = newClouds; // 새로운 구름 리스트로 업데이트

    }
    static void addCloudWater() {
        //구름 칸
        for (Cloud cloud : clouds) {
            int x = cloud.x;
            int y = cloud.y;
            map[x][y]++;
        }
        //대각선 확인
        for (Cloud cloud : clouds){
            int x = cloud.x;
            int y = cloud.y;
            int plusWater = 0;
            for(int i=2;i<=8;i+=2) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(inRange(nx, ny) && map[nx][ny] > 0){
                    plusWater++;
                }
            }
            map[x][y] += plusWater;
        }
    }
    static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }
    static void cloudMove(int dir, int dist) {
        int nx,  ny;
        for(int loop = 0; loop < clouds.size(); loop++) {
            nx = clouds.get(loop).x;
            ny = clouds.get(loop).y;
            for (int i = 0; i < dist; i++) {
                nx += dx[dir];
                ny += dy[dir];
                if (nx < 0) {
                    nx = n - 1;
                } else if (nx >= n) {
                    nx = 0;
                }

                if (ny < 0) {
                    ny = n - 1;
                } else if (ny >= n) {
                    ny = 0;
                }
            }
            clouds.set(loop, new Cloud(nx, ny));
        }
    }
    static class Cloud {
        int x;
        int y;
        public Cloud(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
