import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + 1;
            if(i%2==0){dp[i] = Math.min(dp[i], dp[i/2] + 1);}
            if(i%3==0){dp[i] = Math.min(dp[i], dp[i/3] + 1);}
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
