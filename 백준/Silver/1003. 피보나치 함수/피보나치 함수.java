import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[] arr;
    static int len;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        if(n==0){bw.write(0 + " " + 0); return;}

        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            len = Math.max(arr[i], len);
        }
        dp = new int[41][2];
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;
        for(int i=2;i<=len;i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        for(int i=0;i<n;i++){
            bw.write(dp[arr[i]][0] + " " + dp[arr[i]][1]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
