import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        dp = new int[n+2];
        dp[1] = 1; dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        bw.write(String.valueOf(dp[n] % 15746));
        bw.flush();
        bw.close();
        br.close();
    }
}
