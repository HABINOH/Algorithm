import java.util.*;
import java.io.*;

public class Main {
    static long[][][] dp;
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());
        tree = new int[t+1];
        for(int i=1;i<=t;i++){
            tree[i] = Integer.parseInt(br.readLine());
        }

        dp = new long[t+1][w+2][3];
        
        for(int i=1;i<=t;i++){
            for(int j=1;j<=w+1;j++){
                if(tree[i]==1){
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]);
                }else{
                    if(i==1 && j==1){continue;}
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
                    dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]) + 1;
                }
            }
        }
        long result = 0;
        for(int i=1;i<=w+1;i++){
            result = Math.max(dp[t][i][1], dp[t][i][2]);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
