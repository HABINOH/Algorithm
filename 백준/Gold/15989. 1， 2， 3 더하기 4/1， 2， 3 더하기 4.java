import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(stk.nextToken());

        int[][] dp = new int[10001][4];
        dp[1][1] = 1;
        dp[2][1] = 1; dp[2][2] = 1;
        dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;
        for(int i=4;i<=10000;i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
        for(int i=0;i<tc;i++){
            int t = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[t][1] + dp[t][2] + dp[t][3]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
