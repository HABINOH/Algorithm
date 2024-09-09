import java.util.*;
import java.io.*;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int[] T = new int[n];
        int[] P = new int[n];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(stk.nextToken());
            P[i] = Integer.parseInt(stk.nextToken());
        }

        dp = new long[n+1];
        for(int i=0;i<n;i++){
            if(i+T[i] <= n){ // 날짜가 넘어가지 않는 범위 내에서
                dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]); //값을 누적시킨다
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
