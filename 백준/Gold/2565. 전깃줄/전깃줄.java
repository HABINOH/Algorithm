import java.util.*;
import java.io.*;

public class Main {
    static int[][] wire;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        wire = new int[n][2];
        dp = new int[n];

        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            wire[i][0] = Integer.parseInt(stk.nextToken());
            wire[i][1] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(wire[i][1] > wire[j][1]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        bw.write(String.valueOf(n - max));
        bw.flush();
        bw.close();
        br.close();
    }

}
