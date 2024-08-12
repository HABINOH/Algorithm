import java.util.*;
import java.io.*;
public class Main {
    static int[][] wheel = new int[5][8];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        //바퀴 입력
        for(int i=1;i<=4;i++){
            String str = br.readLine();
            for(int j=0;j<8;j++) {
                wheel[i][j] = str.charAt(j) - '0';
            }
        }
        //회전 입력
        int rotate = Integer.parseInt(br.readLine());
        while(rotate-- > 0){
            stk = new StringTokenizer(br.readLine());
            int wheelNumber = Integer.parseInt(stk.nextToken());
            int dir = Integer.parseInt(stk.nextToken());;

            int[] wheelDir = getDir(wheelNumber, dir);
            rotateWheel(wheelDir);
        }
        bw.write(String.valueOf(cal()));
        bw.flush();
        bw.close();
        br.close();
    }
    static int[] getDir(int number, int dir){
        int[] direction = new int[5];
        direction[number] = dir; //회전 하는 바퀴, 방향
        //왼쪽 바퀴 회전 여부
        for(int i=number; i>1; i--){
            if(wheel[i][6] == wheel[i-1][2]){
                break;
            }
            //기존의 바퀴 반대 방향 회전
            direction[i-1] = direction[i] * -1;
        }
        //오른쪽 바퀴 회전 여부
        for(int i=number; i<4; i++){
            if(wheel[i][2] == wheel[i+1][6]){
                break;
            }
            //기존의 바퀴 반대 방향 회전
            direction[i+1] = direction[i] * -1;
        }
        return direction;
    }
    static void rotateWheel(int[] dir){
        for(int i=1;i<=4;i++) {
            if (dir[i] != 0) {
                if (dir[i] == 1) { //오른쪽 회전
                    int temp = wheel[i][7];
                    for (int j = 7; j > 0; j--) {
                        wheel[i][j] = wheel[i][j - 1];
                    }
                    wheel[i][0] = temp;
                } else if (dir[i] == -1) { //왼쪽 회전
                    int temp = wheel[i][0];
                    for (int j = 0; j < 7; j++) {
                        wheel[i][j] = wheel[i][j + 1];
                    }
                    wheel[i][7] = temp;
                }
            }
        }
    }
    static int cal(){
        int result = 0;
        int sum = 1;
        for(int i=1;i<=4;i++){
            if(wheel[i][0] == 1){
                result += sum;
            }
            sum *= 2;
        }
        return result;
    }
}
