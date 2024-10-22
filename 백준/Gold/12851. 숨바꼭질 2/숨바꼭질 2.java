import java.io.*;
import java.util.*;

public class Main {
    static class Position{
        int dis;
        int count;
        public Position(int dis, int count){
            this.dis = dis;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int subin = Integer.parseInt(stk.nextToken());
        int sister = Integer.parseInt(stk.nextToken());

        
        int[] visited = new int[100001];
        Arrays.fill(visited, -1); // -1로 초기화 방문 여부를 확인
        visited[subin] = 0; // 수빈이의 위치 0초로 시작

        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(subin, 0));

        int minDis = Integer.MAX_VALUE; // 최소 시간
        int ways = 0; // 같은 시간에 동생을 찾는 방법의 수

        while (!queue.isEmpty()) {
            Position curPos = queue.poll();

            if (curPos.count > minDis) {
                continue;
            }

            if (curPos.dis == sister) {
                if (curPos.count < minDis) {
                    minDis = curPos.count;
                    ways = 1;
                }else if(curPos.count == minDis){
                    ways++;
                }
                continue;
            }
            int[] nextPositions = {curPos.dis + 1, curPos.dis - 1, curPos.dis * 2};
            for(int nextPos : nextPositions){
                if(nextPos >= 0 && nextPos <= 100000){ //갈 수 있는 위치
                    //아직 방문하지 않았거나 같은 시간에 방문할 수 있으면
                    if(visited[nextPos] == -1 || visited[nextPos] == curPos.count + 1){
                        visited[nextPos] = curPos.count + 1;
                        queue.add(new Position(nextPos, curPos.count + 1));
                    }
                }
            }
        }
        bw.write(minDis + "\n" + ways);
        
        bw.flush();
        bw.close();
        br.close();
    }
}
