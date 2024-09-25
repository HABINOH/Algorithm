import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            int idx=100001;
            for(int j=1; j<=i/2;j++){
                if(j*j==i){
                    idx = 1;
                    break;
                }else{
                    idx = Math.min(idx, dp[i-j] + dp[j]);
                }
            }
            dp[i] = idx;
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
