import java.util.*;
import java.io.*;

public class Main {
    static long[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 좌석 수
        int m = Integer.parseInt(br.readLine()); // VIP 좌석 수

        arr = new int[m + 2]; // VIP 좌석 배열
        for (int i = 1; i <= m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[0] = 0; // 시작점 추가
        arr[m + 1] = n + 1; // 끝점 추가

        // dp 배열 초기화
        dp = new long[n + 1];
        dp[0] = 1;
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        long result = 1;
        for (int i = 1; i <= m + 1; i++) {
            int idx = arr[i] - arr[i - 1] - 1; // 구간 별 경우의 수 계산
            result *= dp[idx]; // 곱해서 경우의 수 누적
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
