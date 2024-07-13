import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());

        int[][] arr = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int[][] dp  = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
            }
        }

        int result = 0;
        for(int i=1;i<=n;i++){
            result = Math.max(dp[n][i], result);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}