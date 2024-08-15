import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,-1,1}; //동,서,북,남
    static int[] dy = {1,-1,0,0};
    static int[][] paper;
    static boolean[][] visited;
    static int result = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        paper = new int[n][m];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                paper[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                visited[i][j] = true;
                dfs(1,i,j,n,m,paper[i][j]);
                visited[i][j] = false;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int depth, int x, int y, int n, int m, int sum){
        if(depth == 4){
            result = Math.max(result, sum);
            return;
        }
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(inRange(nx, ny, n, m) && !visited[nx][ny]){
                if(depth == 2){ //기존 좌표 기준 dfs
                    visited[nx][ny] = true;
                    dfs(depth+1, x, y, n, m, sum+paper[nx][ny]);
                    visited[nx][ny] = false;
                }
                visited[nx][ny] = true;
                dfs(depth+1, nx, ny, n, m, sum+paper[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
    static boolean inRange(int x, int y, int n, int m){
        return x>=0 && y>=0 && x<n && y<m;
    }
}
