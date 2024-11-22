import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static int[][] grid;
    static int[] dpLeft;
    static int[] dpRight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());

        grid = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                grid[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        dp = new int[N][M];
        dp[0][0] = grid[0][0];
        for(int col=1;col<M;col++){ //첫번째 행 값 누적합 초기화
            dp[0][col] = dp[0][col-1] + grid[0][col];
        }

        for(int row=1;row<N;row++){
            dpLeft = new int[M];
            dpRight = new int[M];

            //왼쪽 -> 오른쪽
            dpLeft[0] = dp[row-1][0] + grid[row][0];
            for(int col=1;col<M;col++){
                dpLeft[col] = Math.max(dpLeft[col-1], dp[row-1][col]) + grid[row][col];
            }

            //오른쪽 -> 왼쪽
            dpRight[M-1] = dp[row-1][M-1] + grid[row][M-1];
            for(int col=M-2;col>=0;col--){
                dpRight[col] = Math.max(dpRight[col+1], dp[row-1][col]) + grid[row][col];
            }

            //현재 행 이동 누적 dp 값 갱신
            for(int col=0;col<M;col++){
                dp[row][col] = Math.max(dpLeft[col], dpRight[col]);
            }
        }

        bw.write(String.valueOf(dp[N-1][M-1]));
        bw.flush();
        bw.close();
        br.close();
    }
}
