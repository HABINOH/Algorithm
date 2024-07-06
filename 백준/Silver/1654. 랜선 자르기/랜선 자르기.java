import java.io.*;
import java.util.*;
public class Main {
    static int k;
    static long n;
    static long[] lan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        k = Integer.parseInt(stk.nextToken());
        n = Long.parseLong(stk.nextToken());

        lan = new long[k];
        for(int i=0;i<k;i++){
            lan[i] = Long.parseLong(br.readLine());
        }

        long l = 0;
        long h = Long.MAX_VALUE;

        while(l+1 < h){
            long mid = (l+h) / 2;
            if(check(mid)){
                l = mid;
            } else {
                h = mid;
            }
        }
        bw.write(String.valueOf(l));
        bw.flush();
    }
    static boolean check(long mid){
        long sum = 0;
        for(int i=0;i<k;i++){
            sum += lan[i] / mid;
        }
        return sum >= n;
    }
}