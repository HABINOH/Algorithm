import java.io.*;
import java.util.*;

public class Main {
    static int[] board = new int[101];
    static int[] visited = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        for(int i=1;i<=100;i++){
            board[i] = i;
        }

        for(int i=0;i<n+m;i++){
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            board[x] = y;
        }

        bfs();
        bw.write(String.valueOf(visited[board[100]]));
        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()){
            int nowNum = queue.poll();
            for(int i=1;i<=6;i++){
                int newNum = nowNum + i;

                if(newNum > 100){continue;}
                if(visited[board[newNum]] == 0){
                    queue.add(board[newNum]);
                    visited[board[newNum]] = visited[board[nowNum]] + 1;
                }
                if(visited[board[newNum]] == 100){
                    return;
                }
            }
        }
    }
}
