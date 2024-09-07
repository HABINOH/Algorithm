import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    static int[] arr;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        dp = new int[n];
        dp[0] = arr[0];
        result = dp[0];
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            result = Math.max(result, dp[i]);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
