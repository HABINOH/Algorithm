import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int l;
    static int[] restArea;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        l = Integer.parseInt(stk.nextToken());

        restArea = new int[n+2];
        restArea[0] = 0;
        stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            restArea[i] = Integer.parseInt(stk.nextToken());
        }
        restArea[n+1] = l;

        Arrays.sort(restArea);

        int start = 1;
        int end = l-1;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(check(mid)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(start));
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean check(int mid){
        int sum = 0;
        for(int i=1;i<=n+1;i++){
            sum += (restArea[i] - restArea[i-1] - 1) / mid;
        }
        return sum > m;
    }
}