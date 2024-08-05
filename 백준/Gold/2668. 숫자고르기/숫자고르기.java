import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visit;
    static ArrayList<Integer> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        visit = new boolean[N + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int j = 1; j <= N; j++) {
            visit[j] = true;
            dfs(j, j);
            visit[j] = false;
        }

        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static void dfs(int value, int i) {
        if (visit[arr[value]] == false) {
            visit[arr[value]] = true;
            dfs(arr[value], i);
            visit[arr[value]] = false;
        }
        if (arr[value] == i) {
            result.add(arr[value]);
        }
    }
}