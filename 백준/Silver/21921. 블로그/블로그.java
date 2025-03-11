import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int x = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        int[] prefixSum = new int[n+1];

        for(int i=1;i<=n;i++){
            prefixSum[i] = prefixSum[i-1] + Integer.parseInt(stk.nextToken());
        }

        int maxDay = 0, cnt = 0;
        for(int i=1;x+i-1<=n;i++){
            int visitedNumber = prefixSum[x+i-1] - prefixSum[i-1];

            if(visitedNumber > maxDay){
                maxDay = visitedNumber;
                cnt = 1;
            }else if(visitedNumber == maxDay){
                cnt++;
            }
        }
        if(maxDay != 0){
            bw.write(String.valueOf(maxDay));
            bw.newLine();
            bw.write(String.valueOf(cnt));
        }else {
            bw.write("SAD");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
