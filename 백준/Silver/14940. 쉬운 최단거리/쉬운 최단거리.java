import java.io.*;
import java.util.*;

public class Main {
    static class Point{
        int x;
        int y;
        int dis;
        public Point(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    static int[][] board;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int n;
    static int m;
    static int[][] result;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        Queue<Point> queue = new LinkedList<>();
        board = new int[n][m];
        result = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
                if(board[i][j] == 2){
                    queue.add(new Point(i,j, 0));
                    visited[i][j] = true;
                    result[i][j] = 0;
                }else if(board[i][j] == 0){
                    result[i][j] = 0;
                }else{
                    result[i][j] = -1;
                }
            }
        }

        while(!queue.isEmpty()){
            Point now = queue.poll();

            for(int i=0;i<4;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if(outRange(nx, ny) || visited[nx][ny]){
                    continue;
                }else if(board[nx][ny] == 0){
                    result[nx][ny] = 0;
                }else{
                    queue.add(new Point(nx, ny, now.dis + 1));
                    result[nx][ny] = now.dis + 1;
                    visited[nx][ny] = true;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                bw.write(result[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static boolean outRange(int x, int y){
        return x<0 || y<0 || x>=n || y>=m;
    }
}
