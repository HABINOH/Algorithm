import java.util.*;
import java.io.*;

public class Main {
    static int[] arr;
    static int[] diff;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(arr);
        diff = new int[n];
        for(int i=1;i<n;i++){
            diff[i-1] = arr[i] - arr[i-1];
        }

        Arrays.sort(diff);
        int answer = 0;
        for(int i=0;i<=n-k;i++){
            answer += diff[i];
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
