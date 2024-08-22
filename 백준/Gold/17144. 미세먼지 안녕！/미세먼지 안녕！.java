import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int r,c;
    static int[][] map;
    static int clear = -1;
    static Queue<Point> dusts = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        r = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        int t = Integer.parseInt(stk.nextToken());

        map = new int[r][c];
        for(int i=0;i<r;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j] == -1 && clear == -1){
                    clear = i;
                }
            }
        }

        for(int i=0;i<t;i++){
            findDust();
            spread();
            clean();
        }

        bw.write(String.valueOf(cal()));
        bw.flush();
        bw.close();
        br.close();
    }
    static int cal(){
        int result = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j] > 0){
                    result += map[i][j];
                }
            }
        }
        return result;
    }
    static void findDust(){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j] > 0){
                    dusts.add(new Point(i,j,map[i][j]));
                }
            }
        }
    }
    static void spread(){
        while(!dusts.isEmpty()){
            Point cur = dusts.poll();
            if(cur.dust < 5){continue;}
            int spreadDust = cur.dust / 5;
            int count = 0;
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(inRange(nx, ny) && map[nx][ny] != -1){
                    map[nx][ny] += spreadDust;
                    count++;
                }
            }
            map[cur.x][cur.y] -= spreadDust * count;
        }
    }
    static void clean(){
        int top = clear;
        int bottom = clear+1;
        //반시계 방향 (위쪽 공기청정기)
        for(int i=top-1; i>0; i--){ // 아래쪽으로
            map[i][0] = map[i-1][0];
        }
        for(int i=0; i<c-1; i++){ // 왼쪽으로
            map[0][i] = map[0][i+1];
        }
        for(int i=0; i<top; i++){ // 위쪽으로
            map[i][c-1] = map[i+1][c-1];
        }
        for(int i=c-1; i>1; i--){ // 오른쪽으로
            map[top][i] = map[top][i-1];
        }
        map[top][1] = 0;

        //시계 방향 (아래쪽 공기청정기)
        for (int i=bottom+1; i<r-1; i++) { // 위쪽으로
            map[i][0] = map[i + 1][0];
        }
        for (int i=0; i < c-1; i++) { // 왼쪽으로
            map[r-1][i] = map[r-1][i+1];
        }
        for (int i=r-1; i>bottom; i--){ // 아래쪽으로
            map[i][c-1] = map[i-1][c-1];
        }
        for (int i=c-1; i>1; i--) { // 오른쪽으로
            map[bottom][i] = map[bottom][i-1];
        }
        map[bottom][1] = 0;
    }

    static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<r && y<c;
    }
    static class Point{
        int x;
        int y;
        int dust;
        public Point(int x, int y, int dust){
            this.x = x;
            this.y = y;
            this.dust = dust;
        }
    }
}
