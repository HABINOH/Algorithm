import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        int[] w = new int[n+1];
        int[] v = new int[n+1];
        for(int i=1;i<=n;i++){
            stk = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(stk.nextToken());
            v[i] = Integer.parseInt(stk.nextToken());
        }

        int[][] dp = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(w[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - w[i]] + v[i]);
                }
            }
        }
        bw.write(String.valueOf(dp[n][k]));
        bw.flush();
        bw.close();
        br.close();
    }
}
