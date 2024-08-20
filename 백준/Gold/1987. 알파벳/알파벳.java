import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int r;
    static int c;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());

        map = new char[r][c];
        for(int i=0;i<r;i++){
            String str = br.readLine();
            for(int j=0;j<c;j++){
                map[i][j] = str.charAt(j);
            }
        }
        visited = new boolean[r][c];
        boolean[] alphabets = new boolean[26];
        visited[0][0] = true;
        alphabets[map[0][0] - 'A'] = true;
        dfs(0,0,alphabets, 1);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int x, int y, boolean[] alphabets, int depth){
        answer = Math.max(answer, depth);
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny) && !visited[nx][ny]) {
                char alphabet = map[nx][ny];
                if(!alphabets[alphabet - 'A']) {
                    visited[nx][ny] = true;
                    alphabets[alphabet - 'A'] = true;
                    dfs(nx, ny, alphabets, depth + 1);
                    alphabets[alphabet - 'A'] = false;
                    visited[nx][ny] = false;
                }
            }
        }
    }
    static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<r && y<c;
    }
}
