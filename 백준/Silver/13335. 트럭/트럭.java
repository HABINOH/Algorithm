import java.io.*;
import java.util.*;

public class Main {
    static Queue<Integer> car = new LinkedList<>();
    static Queue<Integer> bridge = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            car.add(Integer.parseInt(stk.nextToken()));
        }
        for(int i=0;i<w;i++){
            bridge.add(0);
        }

        int nowBridgeWeight = 0;
        int time = 0;
        while(!bridge.isEmpty()){
            time++;
            nowBridgeWeight -= bridge.poll();
            if(car.isEmpty()){continue;}
            
            if(car.peek() + nowBridgeWeight <= l){
                bridge.add(car.peek());
                nowBridgeWeight += car.poll();
            }else{
                bridge.add(0);
            }
        }
        bw.write(String.valueOf(time));
        bw.flush();
        bw.close();
        br.close();
    }
}