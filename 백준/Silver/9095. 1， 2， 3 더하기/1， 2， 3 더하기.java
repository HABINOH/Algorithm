import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        dp = new int[11];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<11;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        for(int i=0;i<n;i++){
            int number = Integer.parseInt(br.readLine());
            bw.write(String.valueOf(dp[number]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
