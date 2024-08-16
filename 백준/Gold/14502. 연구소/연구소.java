import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] map;
    static int[][] copyMap;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        copyMap = new int[n][m];
        map = new int[n][m];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(1, i, j, n, m);
                    map[i][j] = 0;
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int depth, int x, int y, int n, int m){
        if(depth == 3){
            for(int i=0;i<map.length;i++){
                copyMap[i] = Arrays.copyOf(map[i], map[i].length);
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(copyMap[i][j] == 2){
                        bfs(i, j, n, m);
                    }
                }
            }
            answer = Math.max(answer, cal(n, m));
            return;
        }

        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 0){
                    map[i][j] = 1;
                    dfs(depth+1, i, j, n, m);
                    map[i][j] = 0;
                }
            }
        }
    }
    static boolean inRange(int x, int y, int n, int m){
        return x>=0 && y>=0 && x<n && y<m;
    }
    static void bfs(int x, int y, int n, int m){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        copyMap[x][y] = 2;
        while(!queue.isEmpty()){
            Point virus = queue.poll();

            for(int i=0;i<4;i++) {
                int nx = virus.x + dx[i];
                int ny = virus.y + dy[i];

                if(inRange(nx,ny,n,m) && copyMap[nx][ny] == 0){
                    queue.add(new Point(nx, ny));
                    copyMap[nx][ny] = 2;
                }
            }
        }
    }
    static int cal(int n, int m){
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(copyMap[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
