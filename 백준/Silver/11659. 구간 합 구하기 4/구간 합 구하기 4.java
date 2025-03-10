import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        int[] prefixSum = new int[n+1];

        for(int i=1;i<=n;i++){
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(stk.nextToken());
        }

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());

            bw.write(String.valueOf(prefixSum[to] - prefixSum[from-1]));
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
