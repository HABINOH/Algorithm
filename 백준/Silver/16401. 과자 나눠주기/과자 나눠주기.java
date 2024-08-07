import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int[] snack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        int start = 1;
        int end = 1;

        snack = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            snack[i] = Integer.parseInt(stk.nextToken());
            end = Math.max(end, snack[i]);
        }
        int result = 0;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(check(mid)){
                start = mid + 1;
                result = mid;
            }else{
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean check(int mid){
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += snack[i] / mid;
            if(sum >= m) break;
        }
        return sum >= m;
    }
}