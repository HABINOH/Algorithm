import java.io.*;
import java.util.*;

public class Main {
    static long n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Long.parseLong(br.readLine());
        long l = 0;
        long h = n;
        while(l <= h){
            long mid = (l+h) / 2;
            if(check(mid)){
                h = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        bw.write(String.valueOf(l));
        bw.flush();
    }
    static boolean check(long mid){
        return Math.pow(mid, 2) >= n;
    }
}
