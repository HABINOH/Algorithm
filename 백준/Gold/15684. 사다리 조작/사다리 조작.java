import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int answer;
    static boolean isFinish;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken()); // 세로선의 수
        int m = Integer.parseInt(stk.nextToken()); // 연결된 가로선의 수
        int h = Integer.parseInt(stk.nextToken()); // 놓을 수 있는 가로선의 위치 개수

        map = new int[h+1][n+1];

        for(int i = 0; i < m; i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());

            map[a][b] = 1;   // 우측으로 이동
            map[a][b+1] = 2; // 좌측으로 이동
        }

        for(int i = 0; i <= 3; i++){
            answer = i; // 추가할 가로선의 수
            dfs(1, 1, 0, n, h);
            if(isFinish) break;
        }

        bw.write((isFinish) ? String.valueOf(answer) : "-1");
        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int startX, int startY, int add, int n, int h){
        if(isFinish) return;

        if (answer == add){
            if(check(n, h)){
                isFinish = true;
            }
            return;
        }

        for(int i = startY; i <= h; i++){
            for(int j = (i == startY ? startX : 1); j < n; j++){ // 가로선을 추가할 수 있는지 검사
                if(map[i][j] == 0 && map[i][j+1] == 0){ // 가로선이 놓여 있지 않다면
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    dfs(j + 2, i, add + 1, n, h); // j + 2로 다음 가로선은 2칸 이상 떨어진 곳에서 시작
                    map[i][j] = 0;
                    map[i][j+1] = 0;
                }
            }
        }
    }

    static boolean check(int n, int h){
        // i번 출발 -> i번 도착 검사
        for(int i = 1; i <= n; i++){
            int nx = i;
            for(int ny = 1; ny <= h; ny++){
                if(map[ny][nx] == 1){ nx++; } // 우측으로 이동
                else if(map[ny][nx] == 2){ nx--; } // 좌측으로 이동
            }
            if(nx != i) return false;
        }
        return true;
    }
}
