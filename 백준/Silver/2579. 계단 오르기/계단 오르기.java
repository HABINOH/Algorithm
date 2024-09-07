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

        arr = new int[301];
        for(int i=1;i<=n;i++){
            int number = Integer.parseInt(br.readLine());
            arr[i] = number;
        }

        dp = new int[301];
        dp[1] = arr[1];
        dp[2] = Math.max(arr[1], arr[1] + arr[2]);
        dp[3] = Math.max(arr[1], arr[2]) + arr[3];
        for(int i=4; i<=n; i++){
            dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
