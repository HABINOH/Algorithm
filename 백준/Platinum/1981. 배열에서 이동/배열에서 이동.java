import javax.security.auth.login.AccountNotFoundException;
import java.io.*;
import java.util.*;

public class Main {

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int n;
    static int minNum = Integer.MAX_VALUE;
    static int maxNum = Integer.MIN_VALUE;
    static int[][] arr;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        StringTokenizer stk;
        for(int i=0;i<n;i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
                minNum = Math.min(minNum, arr[i][j]);
                maxNum = Math.max(maxNum, arr[i][j]);
            }
        }
        solution(0, maxNum - minNum);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    static void solution(int st, int en){
        while(st <= en){
            int mid = st + (en - st) / 2;
            if (check(mid)) {
                answer = mid;
                en = mid - 1;
            }else{
                st = mid + 1;
            }
        }
    }
    static boolean check(int mid){
        for(int i=minNum; i+mid <= maxNum; i++){
            int start = i;
            int end = i + mid;

            if(arr[0][0] < start || arr[0][0] > end){
                continue;
            }

            Queue<Point> queue = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][n];

            queue.add(new Point(0,0));
            visited[0][0] = true;

            while(!queue.isEmpty()){
                Point now = queue.poll();

                if(now.x == n-1 && now.y == n-1){
                    return true;
                }

                for(int dir=0;dir<4;dir++){
                    int nx = now.x + dx[dir];
                    int ny = now.y + dy[dir];

                    if(inRange(nx, ny) || visited[nx][ny] || arr[nx][ny] < start || arr[nx][ny] > end){
                        continue;
                    }

                    queue.add(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }
    static boolean inRange(int x, int y){
        return x<0 || y<0 || x>=n || y>=n;
    }
}