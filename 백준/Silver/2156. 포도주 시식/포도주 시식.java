import java.util.*;
import java.io.*;

public class Main {
    static long[] dp;
    static int[] grapes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        grapes = new int[n+1];
        for(int i=1;i<=n;i++){
            grapes[i] = Integer.parseInt(br.readLine());
        }

        dp = new long[n+1];
        for(int i=1;i<=n;i++){
            if(i==1){dp[i] = grapes[i];}
            else if(i==2){dp[i] = grapes[i-1] + grapes[i];}
            else{
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + grapes[i], dp[i-3] + grapes[i-1] + grapes[i]));
            }
        }
        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
        br.close();
    }
}
