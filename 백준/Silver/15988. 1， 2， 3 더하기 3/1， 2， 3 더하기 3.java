import java.util.*;
import java.io.*;

public class Main {
    static long[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int len = 0;
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            len = Math.max(len, arr[i]);
        }

        dp = new long[len+1];
        if(len > 0){ dp[1] = 1; }
        if(len > 1){ dp[2] = 2; }
        if(len > 2){ dp[3] = 4; }
        for(int i=4; i<=len; i++){
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009 ;
        }

        for (int i : arr) {
            bw.write(String.valueOf(dp[i] % 1_000_000_009));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
