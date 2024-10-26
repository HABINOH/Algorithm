import java.util.*;
import java.io.*;

public class Main {
    static int n,m,l,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> minPQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());

        int n = Integer.parseInt(stk.nextToken());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(br.readLine());

            if(minPQ.size() == maxPQ.size()){
                maxPQ.add(num);
            }else{
                minPQ.add(num);
            }

            if(!minPQ.isEmpty() && !maxPQ.isEmpty()){
                if(maxPQ.peek() > minPQ.peek()){
                    int tempNum = maxPQ.poll();
                    maxPQ.add(minPQ.poll());
                    minPQ.add(tempNum);
                }
            }
            bw.write(String.valueOf(maxPQ.peek()));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
