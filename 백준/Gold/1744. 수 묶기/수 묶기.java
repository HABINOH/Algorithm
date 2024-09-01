import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static PriorityQueue<Integer> minus = new PriorityQueue<>();
    static PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(stk.nextToken());

            if(number <= 0) {
                minus.offer(number);
            }else{
                plus.offer(number);
            }
        }

        int minusResult = calMinus();
        int plusResult = calPlus();

        bw.write(String.valueOf(minusResult + plusResult));
        bw.flush();
        bw.close();
        br.close();
    }
    static int calMinus(){
        int result = 0;
        while(!minus.isEmpty()){
            int cur = minus.poll();
            if(minus.isEmpty()){
                result += cur;
                break;
            }
            if(minus.peek() == 0){
                minus.poll();
            }else{
                result += cur * minus.poll();
            }
        }
        return result;
    }
    static int calPlus(){
        int result = 0;
        while(!plus.isEmpty()){
            int cur = plus.poll();
            if(plus.isEmpty()){
                result += cur;
                break;
            }
            if(cur == 1){
                result += 1;
            }else if(plus.peek() == 1){
                result += cur + plus.poll();
            }else{
                result += cur * plus.poll();
            }
        }
        return result;
    }
}
