import java.util.*;
import java.io.*;

public class Main {
    static long[] time;
    static int n,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        time = new long[n];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            time[i] = Long.parseLong(stk.nextToken());
        }
        long answer = Long.MAX_VALUE;
        long start = 0;
        long end = Long.MAX_VALUE;
        while(start <= end){
            long mid = start + (end - start) / 2;
            if(check(mid)){
                end = mid - 1;
                answer = Math.min(answer, mid);
            }else {
                start = mid + 1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean check(long mid){
        long sum = 0;
        for(int i=0;i<n;i++){
             sum += mid / time[i];
             if(sum >= m){return true;}
        }
        return sum >= m;
    }
}
