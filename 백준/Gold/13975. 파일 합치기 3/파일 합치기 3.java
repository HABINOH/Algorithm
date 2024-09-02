import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(stk.nextToken());
        while(t-->0){
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int k = Integer.parseInt(br.readLine());
            stk = new StringTokenizer(br.readLine());
            for(int i=0;i<k;i++){
                pq.offer(Long.parseLong(stk.nextToken()));
            }
            long result = 0L;
            while(pq.size() > 1){
                long first = pq.poll();
                long second = pq.poll();
                result += first + second;
                pq.offer(first + second);
            }
            bw.write(String.valueOf(result));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
