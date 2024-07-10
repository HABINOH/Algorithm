import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int c;
    static long[] home;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        c = Integer.parseInt(stk.nextToken());
        home = new long[n];
        for(int i=0;i<n;i++){
            home[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(home);

        long st = 1;
        long en = home[n-1] - home[0];
        long answer = 0;
        while(st <= en){
            long mid = st + (en - st) / 2;
            if (check(mid)) {
                st = mid + 1;
                answer = mid;
            }else{
                en = mid - 1;
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean check(long mid){
        int count = 1;
        long lastLocation = home[0];
        for(int i=1;i<n;i++){
            long location = home[i];
            if(location - lastLocation >= mid){
                count++;
                lastLocation = location;
            }
        }
        return count >= c;
    }
}
