import java.io.*;
import java.util.*;

public class Main {
    static final int WIN = 1, LOSE = 0;
    static int N, S, E;
    static int[] value;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()) - 1;
        E = Integer.parseInt(st.nextToken()) - 1;

        init();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].add(v);
            graph[v].add(u);
        }

        int result = minimax(S, -1, true);
        System.out.println(result == WIN ? "First" : "Second");
    }

    private static int minimax(int now, int parent, boolean isMax) {
        if (now == E) return WIN;

        if (value[now] != -1) return value[now];

        int result = isMax ? LOSE : WIN;
        boolean hasMove = false;

        for (int next : graph[now]) {
            if (next != parent) {
                hasMove = true;
                int nextResult = minimax(next, now, !isMax);
                if (isMax) {
                    result = Math.max(result, nextResult);
                } else {
                    result = Math.min(result, nextResult);
                }
            }
        }

        if (!hasMove) {
            result = LOSE;
        }

        return value[now] = result;
    }

    private static void init() {
        graph = new ArrayList[N];
        value = new int[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
            value[i] = -1;
        }
    }
}