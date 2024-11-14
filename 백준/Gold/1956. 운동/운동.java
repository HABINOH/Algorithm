import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 987654321;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
 
        int[][] arr = new int[V + 1][V + 1];
 
        // 배열 초기화
        for (int i = 1; i <= V; i++) {
            Arrays.fill(arr[i], INF);
            arr[i][i] = 0; // 자기 자신으로 가는 거리는 0
        }
 
        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arr[a][b] = c;
        }
 
        // 플로이드-워셜 알고리즘 수행
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }
 
        // 최소 사이클 찾기
        int ans = INF;
        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j && arr[i][j] != INF && arr[j][i] != INF) {
                    ans = Math.min(ans, arr[i][j] + arr[j][i]);
                }
            }
        }
 
        // 결과 출력
        bw.write((ans == INF ? -1 : ans) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
