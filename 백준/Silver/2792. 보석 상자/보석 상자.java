import java.io.*;
import java.util.*;

public class Main {
    static long n;
    static long m;
    static long MAX = Long.MIN_VALUE;
    static long[] jewelry;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Long.parseLong(stk.nextToken());
        m = Long.parseLong(stk.nextToken());

        jewelry = new long[(int) m];
        for(int i = 0; i < m; i++){
            jewelry[i] = Long.parseLong(br.readLine());
            if(MAX < jewelry[i]) {
                MAX = jewelry[i];
            }
        }

        long result = Long.MAX_VALUE;
        long l = 1;
        long h = MAX;

        while(l <= h){
            long mid = (l + h) / 2;
            if(check(mid)){
                h = mid - 1;
                if(mid < result){
                    result = mid;
                }
            } else {
                l = mid + 1;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }

    static boolean check(long mid){
        long sum = 0;
        for(int i = 0; i < m; i++){
            sum += jewelry[i] / mid;
            if(jewelry[i] % mid != 0){
                sum++;
            }
        }
        return sum <= n;
    }
}
