import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] nodes;
    static boolean[] isFan;
    static boolean[] visited;
    static boolean answer = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(stk.nextToken());

        while(tc --> 0){
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int en = Integer.parseInt(stk.nextToken());

            int distance = en - st;  // 목표 지점까지의 거리
            int maxMove = (int) Math.sqrt(distance); // 가능한 최대 이동 거리의 기준
            int maxMoveSquare = maxMove * maxMove; // 최대 이동 거리의 제곱
            int answer = 0;
            if (distance == maxMoveSquare) {
                 answer = 2 * maxMove - 1;
            } else if (distance <= maxMoveSquare + maxMove) {
                answer = 2 * maxMove;
            } else {
                answer =  2 * maxMove + 1;
            }

            bw.write(String.valueOf(answer));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
