import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[n];
        for(int i=n-1;i>=0;i--) {
            while (!deque.isEmpty() && deque.peekLast() <= arr[i]) {
                deque.pollLast();
            }
            if(deque.isEmpty()){
                result[i] = -1;
            }else{
                result[i] = deque.peekLast();
            }
            deque.addLast(arr[i]);
        }
        for(int i=0;i<n;i++){
            bw.write(result[i] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
