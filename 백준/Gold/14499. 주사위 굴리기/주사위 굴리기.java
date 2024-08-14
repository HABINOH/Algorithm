import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {0,0,0,-1,1}; //동,서,북,남
    static int[] dy = {0,1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[][] map = new int[n][m];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[] numberDice = {0,0,0,0,0,0};
        Dice dice = new Dice(0,1,2,3,4,5);
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            int dir = Integer.parseInt(stk.nextToken());

            int top = dice.top;
            int front = dice.front;
            int back = dice.back;
            int left = dice.left;
            int right = dice.right;
            int bottom = dice.bottom;

            Dice nextDice = null;
            //주사위 방향 변경
            switch(dir){
                case 1: //오른쪽
                    nextDice = new Dice(left, front, back, bottom, top, right);
                    break;
                case 2: //왼쪽
                    nextDice = new Dice(right, front, back, top, bottom, left);
                    break;
                case 3: //위쪽
                    nextDice = new Dice(front, bottom, top, left, right, back);
                    break;
                case 4: //아래쪽
                    nextDice = new Dice(back, top, bottom, left, right, front);
                    break;
            }

            //주사위 이동
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            //이동 가능 여부 확인
            if(!inRange(nx,ny,n,m)){
                continue;
            }

            x = nx;
            y = ny;
            dice = nextDice;

            //주사위 바닥면 확인 및 복사
            if(map[x][y] == 0){
                map[x][y] = numberDice[dice.bottom];
            }else{
                numberDice[dice.bottom] = map[x][y];
                map[x][y] = 0;
            }
            bw.write(String.valueOf(numberDice[dice.top]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean inRange(int x, int y, int n, int m){
        return x>=0 && y>=0 && x<n && y<m;
    }
    /*
     *      back
     * left top right
     *      front
     *     bottom
     * */
    static class Dice{
        int top;
        int front;
        int back;
        int left;
        int right;
        int bottom;
        public Dice(int top, int front, int back, int left, int right, int bottom){
            this.top = top;
            this.front = front;
            this.back = back;
            this.left = left;
            this.right = right;
            this.bottom = bottom;
        }
    }
}
