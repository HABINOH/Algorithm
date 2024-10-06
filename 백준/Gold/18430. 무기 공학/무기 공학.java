import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n,m;
    static int answer;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        visited = new boolean[n][m];
        dfs(0,0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int depth, int sum){
        if(depth == n*m){
            answer = Math.max(answer, sum);
            return;
        }

        int x = depth / m; //행 좌표 (1차원 -> 2차원 변환)
        int y = depth % m; //열 좌표 (1차원 -> 2차원 변환)

        if(!visited[x][y]){
            visited[x][y] = true;
            if(inRange(x+1, y-1) && !visited[x+1][y] && !visited[x][y-1]){
                visited[x+1][y] = true;
                visited[x][y-1] = true;
                dfs(depth + 1, sum + (map[x][y] * 2) + map[x+1][y] + map[x][y-1]);
                visited[x+1][y] = false;
                visited[x][y-1] = false;
            }
            if(inRange(x-1, y+1) && !visited[x-1][y] && !visited[x][y+1]){
                visited[x-1][y] = true;
                visited[x][y+1] = true;
                dfs(depth + 1, sum + (map[x][y] * 2) + map[x-1][y] + map[x][y+1]);
                visited[x-1][y] = false;
                visited[x][y+1] = false;
            }
            if(inRange(x-1, y-1) && !visited[x-1][y] && !visited[x][y-1]){
                visited[x-1][y] = true;
                visited[x][y-1] = true;
                dfs(depth + 1, sum + (map[x][y] * 2) + map[x-1][y] + map[x][y-1]);
                visited[x-1][y] = false;
                visited[x][y-1] = false;
            }
            if(inRange(x+1, y+1) && !visited[x+1][y] && !visited[x][y+1]){
                visited[x+1][y] = true;
                visited[x][y+1] = true;
                dfs(depth + 1, sum + (map[x][y] * 2) + map[x+1][y] + map[x][y+1]);
                visited[x+1][y] = false;
                visited[x][y+1] = false;
            }
            visited[x][y] = false;
        }
        dfs(depth + 1, sum);
    }
    static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<m;
    }
}