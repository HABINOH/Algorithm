import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        paper = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            paper[i] = Integer.parseInt(stk.nextToken());
        }

        int result = 0;
        int start = 1;
        int end = 100000 * 20 + 22;
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
        int count = 0;
        for(int i=0;i<n;i++){
            sum += paper[i];
            if(sum >= mid){
                sum = 0;
                count++;
            }
        }
        return count >= k;
    }
}