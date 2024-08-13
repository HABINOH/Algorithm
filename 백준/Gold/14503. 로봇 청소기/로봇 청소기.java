import java.util.*;
import java.io.*;
public class Main {
    static int[] dx = {-1,0,1,0};//위, 우측, 아래, 왼쪽
    static int[] dy = {0,1,0,-1};
    static int n;
    static int m;
    static int[][] board;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        //방향 0:위, 1:우측 2:아래, 3:좌측
        stk = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());
        int d = Integer.parseInt(stk.nextToken());

        board = new int[n][m];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        clean(r, c, d);
        bw.write(String.valueOf(result+1));
        bw.flush();
        bw.close();
        br.close();
    }
    static void clean(int x, int y, int dir){
        board[x][y] = -1;
        for(int i=0;i<4;i++){
            dir = (dir + 3) % 4; //반시계 방향 전환
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(inRange(nx,ny) && board[nx][ny] == 0){
                result++;
                clean(nx, ny, dir);
                return;
            }
        }
        //후진
        int back = (dir + 2) % 4;
        int bx = x + dx[back];
        int by = y + dy[back];
        if(inRange(bx, by) && board[bx][by] != 1){
            clean(bx, by, dir);
        }
    }
    static boolean inRange(int x, int y){
        return x>=0 || y>=0 || x<n || y<m;
    }
}
