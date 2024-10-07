import java.io.*;
import java.util.*;

public class Main {
    static int[] lamp;
    static int[] finishLamp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        // 초기 전등 상태
        char[] chars = br.readLine().toCharArray();
        lamp = new int[n];
        for (int j=0; j<n; j++) {
            lamp[j] = chars[j] - '0';
        }

        // 목표 전등 상태
        finishLamp = new int[n];
        chars = br.readLine().toCharArray();
        for (int j=0; j<n; j++) {
            finishLamp[j] = chars[j] - '0';
        }

        // 첫 번째 전등을 켰을 경우와 끄지 않았을 경우
        int[] firstOnLamp = lamp.clone();
        int firstTurnOnCount = 1;
        changeLamp(firstOnLamp, 0);  // 첫 번째 전등을 켠 경우

        int[] firstOffLamp = lamp.clone();
        int firstTurnOffCount = 0;   // 첫 번째 전등을 그대로 둔 경우

        // 전등 조작 (첫 번째 전등을 켰을 경우)
        for (int i=1; i<n; i++) {
            if (firstOnLamp[i-1] != finishLamp[i-1]) {
                changeLamp(firstOnLamp, i);
                firstTurnOnCount++;
            }
        }

        // 전등 조작 (첫 번째 전등을 그대로 둔 경우)
        for (int i=1; i<n; i++) {
            if (firstOffLamp[i-1] != finishLamp[i-1]) {
                changeLamp(firstOffLamp, i);
                firstTurnOffCount++;
            }
        }

        // 두 결과 모두 확인
        int result = Integer.MAX_VALUE;
        if (Arrays.equals(firstOnLamp, finishLamp)) {
            result = firstTurnOnCount;
        }
        if (Arrays.equals(firstOffLamp, finishLamp)) {
            result = Math.min(result, firstTurnOffCount);
        }

        if (result == Integer.MAX_VALUE) {
            bw.write(String.valueOf(-1));  // 만들 수 없는 경우
        } else {
            bw.write(String.valueOf(result));  // 최소 조작 횟수 출력
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void changeLamp(int[] lampSwap, int idx) {
        lampSwap[idx] = 1-lampSwap[idx];
        if (idx-1 >= 0) {
            lampSwap[idx-1] = 1-lampSwap[idx-1];
        }
        if (idx+1 < n) {
            lampSwap[idx+1] = 1-lampSwap[idx+1];
        }
    }
}
