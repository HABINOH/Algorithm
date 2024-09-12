import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        arr = new int[n+1];
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int[] prev = new int[n+1];
        Arrays.fill(prev, -1);
        int maxIdx = -1;
        int result = 0;
        dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = 1;
            for(int j=1; j<=i; j++){
                if(arr[i] > arr[j] && dp[j] + 1 > dp[i]){
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if(result < dp[i]){
                result = dp[i];
                maxIdx = i;
            }
        }

        ArrayList<Integer> resultNum = new ArrayList<>();
        while(maxIdx != -1){
            resultNum.add(arr[maxIdx]);
            maxIdx = prev[maxIdx];
        }
        Collections.sort(resultNum);

        bw.write(String.valueOf(result));
        bw.newLine();
        for(int num : resultNum){
            bw.write(num + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
