import java.util.*;
import java.io.*;

public class Main {
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        dp = new long[101];
        dp[1] = 1; dp[2] = 1; dp[3] = 1;
        for(int i=4;i<101;i++){
            dp[i] = dp[i-2] + dp[i-3];
        }
        for(int i=0;i<n;i++){
            bw.write(String.valueOf(dp[Integer.parseInt(br.readLine())]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
