import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,1,0,-1,-1,-1,0,1};
    static int[] dy = {0,1,1,1,0,-1,-1,-1};
    static int minHeight = Integer.MAX_VALUE;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
            }
        }
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]){continue;}
                bfs(i,j,n,m,map[i][j]);
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(int x, int y, int n, int m, int height){
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;
        boolean check = true;
        while(!queue.isEmpty()){
            Point cur = queue.poll();
            for(int i=0;i<8;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(inRange(nx,ny,n,m)){
                    if(map[nx][ny] > height){
                        check = false;
                    }else if(map[nx][ny] == height && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        queue.add(new Point(nx,ny));
                    }
                }
            }
        }
        if(check && height > minHeight){answer++;}
    }
    static boolean inRange(int x, int y, int n, int m){
        return x>=0 && y>=0 && x<n && y<m;
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
