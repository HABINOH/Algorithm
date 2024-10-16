import java.io.*;
import java.util.*;

public class Main {
    static class Top{
        int idx;
        int height;
        public Top(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        Deque<Top> deque = new ArrayDeque<>();
        stk = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int curHeight = Integer.parseInt(stk.nextToken());
            if(deque.isEmpty()){
                bw.write("0 ");
                deque.add(new Top(i, curHeight));
            }else{
                while(true){
                    if(deque.isEmpty()){
                        bw.write("0 ");
                        deque.add(new Top(i, curHeight));
                        break;
                    }
                    Top curTop = deque.peekLast();
                    if(curTop.height > curHeight){
                        bw.write(curTop.idx + " ");
                        deque.add(new Top(i, curHeight));
                        break;
                    }else{
                        deque.pollLast();
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
