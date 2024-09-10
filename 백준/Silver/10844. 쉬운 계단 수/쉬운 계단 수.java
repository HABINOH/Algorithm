import java.util.*;
import java.io.*;

public class Main {
    static long[][] dp;
    static long mod = 1_000_000_000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        dp = new long[n+1][10];
        for(int i=1;i<=9;i++){
            dp[1][i] = 1;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){
                if(j==0){
                    dp[i][j] = dp[i-1][1] % mod;
                }else if(j==9){
                    dp[i][j] = dp[i-1][8] % mod;
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }
        long result = 0;
        for(int i=0;i<=9;i++){
            result = (result + dp[n][i]) % mod;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
