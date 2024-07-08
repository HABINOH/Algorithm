import java.io.*;
import java.util.*;

public class Main {
    static long[] line;
    static long n;
    static long m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Long.parseLong(stk.nextToken());
        m = Long.parseLong(stk.nextToken());
        line = new long[(int)n];
        for(int i=0;i<n;i++){
            line[i] = Long.parseLong(br.readLine());
        }

        long st = 1;
        long en = Long.MAX_VALUE;
        long answer = Long.MAX_VALUE;
        while(st <= en){
            long mid = st + (en - st) / 2;
            if(check(mid)){
                en = mid - 1;
                answer = Math.min(answer, mid);
            }else{
                st = mid + 1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
    }
    static boolean check(long mid){
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += mid / line[i];
            if(sum >= m){return true;}
        }
        return sum >= m;
    }
}
