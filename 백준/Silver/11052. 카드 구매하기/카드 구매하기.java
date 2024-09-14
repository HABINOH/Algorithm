import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        arr = new int[n+1];
        stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp = new int[n+1];
        dp[1] = arr[1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j]);
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
