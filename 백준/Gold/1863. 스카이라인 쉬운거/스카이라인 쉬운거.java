import java.io.*;
import java.util.*;

public class Main {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken()); //높이

            //건물이 끝나는 지점 발견
            while(!deque.isEmpty() && deque.peekLast() > y){
                answer++; //건물 개수 추가
                deque.pollLast(); //높이(건물) 제거
            }
            //높이가 같으면 추가 X
            if(!deque.isEmpty() && deque.peekLast() == y){
                continue;
            }
            if(y>0){deque.addLast(y);}
        }
        //남아 있는 건물 개수 추가
        while(!deque.isEmpty()){
            answer++;
            deque.pollLast();
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
