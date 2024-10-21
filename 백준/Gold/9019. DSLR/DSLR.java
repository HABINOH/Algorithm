import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(stk.nextToken());
        for(int testCase=0; testCase < tc; testCase++){
            stk = new StringTokenizer(br.readLine());
            int startNum = Integer.parseInt(stk.nextToken());
            int endNum = Integer.parseInt(stk.nextToken());

            boolean[] visited = new boolean[10001];
            Queue<Integer> queue = new LinkedList<>();
            String[] cmd = new String[10001];

            visited[startNum] = true;
            queue.add(startNum);
            Arrays.fill(cmd, "");

            while(!queue.isEmpty() && !visited[endNum]){
                int curNum = queue.poll();

                int D = (2 * curNum) % 10000;
                int S = curNum == 0 ? 9999 : curNum - 1;
                int L = (curNum % 1000) * 10 + curNum / 1000;
                int R = (curNum % 10) * 1000 + curNum / 10;


                if(!visited[D]){
                    queue.add(D);
                    visited[D] = true;
                    cmd[D] = cmd[curNum] + "D";
                }
                if(!visited[S]){
                    queue.add(S);
                    visited[S] = true;
                    cmd[S] = cmd[curNum] + "S";
                }
                if(!visited[L]){
                    queue.add(L);
                    visited[L] = true;
                    cmd[L] = cmd[curNum] + "L";
                }
                if(!visited[R]){
                    queue.add(R);
                    visited[R] = true;
                    cmd[R] = cmd[curNum] + "R";
                }
            }
            bw.write(cmd[endNum]);
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
