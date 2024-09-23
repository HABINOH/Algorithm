import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int testCase = 1;
        while(n != 0){
            dp = new int[n][3];
            for(int i=0;i<n;i++){
                stk = new StringTokenizer(br.readLine());
                for(int j=0;j<3;j++){
                    dp[i][j] = Integer.parseInt(stk.nextToken());
                }
            }

            for(int i=1;i<n;i++){
                if(i==1){//처음 경로
                    for(int j=0;j<3;j++){
                        if(j==0){dp[i][0] += dp[i-1][1];}
                        else{
                            dp[i][j] += Math.min(dp[i][j-1], Math.min(dp[i-1][1], dp[i-1][1] + dp[i-1][2]));
                        }
                    }
                }else{ //니머지 경로
                    dp[i][0] += Math.min(dp[i-1][0], dp[i-1][1]);
                    dp[i][1] += Math.min(Math.min(dp[i][0], dp[i-1][0]), Math.min(dp[i-1][1], dp[i-1][2]));
                    dp[i][2] += Math.min(dp[i][1],Math.min(dp[i-1][1], dp[i-1][2]));
                }
            }

            bw.write(testCase++ + ". " + dp[n-1][1]);
            bw.newLine();

            n = Integer.parseInt(br.readLine());
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
