import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] water;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        water = new int[n];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            water[i] = Integer.parseInt(stk.nextToken());
        }

        long start = 1;
        long end = 10000L * 1000002;
        long result = 0;
        while(start <= end){
            long mid = start + (end - start) / 2;
            if(check(mid)){
                start = mid + 1;
                result = start;
            }else{
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(result-1L));
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean check(long mid){
        long sum = 0;
        for(int i=0;i<n;i++){
            sum += water[i] / mid;
        }
        return sum >= k;
    }
}