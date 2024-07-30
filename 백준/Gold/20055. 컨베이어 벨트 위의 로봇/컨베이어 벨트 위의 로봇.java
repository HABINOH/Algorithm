import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> belt;
    static boolean[] robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        belt = new ArrayList<>();
        for(int i=0;i<n*2;i++){
           belt.add(Integer.parseInt(stk.nextToken()));
        }

        robot = new boolean[n*2];
        int count = 0;
        int result = 0;
        while(count < k){
            //벨트 이동
            int last = belt.get(belt.size()-1);
            belt.remove(belt.size()-1);
            belt.add(0, last);

            //로봇 & 벨트 위치 이동
            for(int i=n-1; i>=1; i--){
                robot[i] = robot[i-1];
            }
            robot[n-1] = false;
            robot[0] = false;

            //로봇 이동
            for(int i=n-1; i>=1; i--){
                int power = belt.get(i);
                if(power > 0 && !robot[i] && robot[i-1]){
                    robot[i] = true;
                    robot[i-1] = false;
                    belt.set(i, power-1);
                    if(power - 1 == 0){
                        count++;
                    }
                }
            }

            //로봇 올리기
            int firstBelt = belt.get(0);
            if(firstBelt > 0){
                belt.set(0, firstBelt-1);
                robot[0] = true;
                if(firstBelt == 1){
                    count++;
                }
            }

            //반복 횟수 증가
            result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
