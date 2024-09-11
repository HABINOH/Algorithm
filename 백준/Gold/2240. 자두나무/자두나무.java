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
                if(tree[i]==1){ //1번 나무에서 자두가 떨어질 때
                    //1번 나무에 있을 때 (자두 먹음)
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]) + 1;
                    //2번 나무에 있을 때 (자두 못 먹음)
                    dp[i][j][2] = Math.max(dp[i-1][j][2], dp[i-1][j-1][1]);
                }else{
                    //첫 번째 시간에 이동이 한 번도 이루어지지 않은 상태에서 2번 나무에서 자두를 받을 수 없는 상황 처리
                    if(i==1 && j==1){continue;}
                    //1번 나무에 있을 때 (자무 못 먹음)
                    dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][2]);
                    //2번 나무에 있을 때 (자두 먹음)
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
