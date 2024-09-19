import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        numbers = new int[n+1];
        dp = new int[k+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            numbers[i] = Integer.parseInt(br.readLine());
            for(int j=numbers[i]; j<=k; j++){
                //dp[i][j] = dp[i-1][j] + dp[i][j-numbers[i]];
                dp[j] += dp[j - numbers[i]];
            }
        }
        bw.write(String.valueOf(dp[k]));
        bw.flush();
        bw.close();
        br.close();
    }
}
