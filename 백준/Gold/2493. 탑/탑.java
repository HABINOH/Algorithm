import java.util.*;
import java.io.*;
public class Main {
    static class Top{
        int idx;
        int height;
        public Top(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        Deque<Top> deque = new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            int height = Integer.parseInt(stk.nextToken());
            if(deque.isEmpty()){
                bw.write("0 ");
                deque.addLast(new Top(i, height));
            }else{
                while(true){
                    if(deque.isEmpty()){
                        bw.write("0 ");
                        deque.addLast(new Top(i, height));
                        break;
                    }
                    Top top = deque.peekLast();
                    if(top.height > height){
                        bw.write(top.idx + " ");
                        deque.addLast(new Top(i, height));
                        break;
                    }else{
                        deque.pollLast();
                    }
                }
            }
        }

        bw.flush();
        bw.flush();
        bw.close();
        br.close();
    }

}
