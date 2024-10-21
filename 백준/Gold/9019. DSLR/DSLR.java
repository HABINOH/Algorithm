import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < tc; testCase++) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int startNum = Integer.parseInt(stk.nextToken());
            int endNum = Integer.parseInt(stk.nextToken());

            // 배열 크기 최적화 (10000)
            boolean[] visited = new boolean[10000];
            int[] parent = new int[10000];
            char[] cmd = new char[10000];
            Queue<Integer> queue = new LinkedList<>();

            visited[startNum] = true;
            parent[startNum] = -1;
            queue.add(startNum);

            while (!queue.isEmpty()) {
                int curNum = queue.poll();

                // 목표 도달 시 탈출
                if (curNum == endNum) {
                    break;
                }

                // DSLR 연산 처리
                int[] nextNums = new int[4];
                char[] commands = {'D', 'S', 'L', 'R'};

                nextNums[0] = (curNum * 2) % 10000;  // D 명령어
                nextNums[1] = (curNum == 0) ? 9999 : curNum - 1;  // S 명령어
                nextNums[2] = (curNum % 1000) * 10 + curNum / 1000;  // L 명령어
                nextNums[3] = (curNum % 10) * 1000 + curNum / 10;  // R 명령어

                // 4가지 명령어에 따른 처리
                for (int i = 0; i < 4; i++) {
                    int nextNum = nextNums[i];
                    if (!visited[nextNum]) {
                        visited[nextNum] = true;
                        parent[nextNum] = curNum;
                        cmd[nextNum] = commands[i];
                        queue.add(nextNum);

                        if (nextNum == endNum) {
                            break;
                        }
                    }
                }
            }

            // 경로 복원
            StringBuilder path = new StringBuilder();
            int current = endNum;
            while (current != startNum) {
                path.append(cmd[current]);
                current = parent[current];
            }

            bw.write(path.reverse().toString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
