import java.util.*;
import java.io.*;

public class Main {
    static long[][] dp;
    static int[][] sticker;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            sticker = new int[3][n+1];

            for(int idx = 1; idx <= 2; idx++) {
                StringTokenizer stk = new StringTokenizer(br.readLine());
                for (int i = 1; i <= n; i++) {
                    sticker[idx][i] = Integer.parseInt(stk.nextToken());
                }
            }

            dp = new long[3][n+1];
            dp[1][1] = sticker[1][1];
            dp[2][1] = sticker[2][1];
            for(int i=2;i<=n;i++){
                dp[1][i] = Math.max(dp[2][i-1], dp[2][i-2]) + sticker[1][i];
                dp[2][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[2][i];
            }
            long result = Math.max(dp[1][n], dp[2][n]);
            bw.write(String.valueOf(result));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
