import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static long[] snack;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stk.nextToken());
        n = Integer.parseInt(stk.nextToken());

        long start = 1;
        long end = 1;

        snack = new long[n];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            snack[i] = Long.parseLong(stk.nextToken());
            end = Math.max(end, snack[i]);
        }
        Arrays.sort(snack);
        long result = 0;
        while(start <= end){
            long mid = start + (end - start) / 2;
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
    static boolean check(long mid){
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += snack[i] / mid;
        }
        return sum >= m;
    }
}