import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 수열의 각 숫자의 등장 여부를 체크하기 위한 배열
        boolean[] visited = new boolean[100001]; // 숫자의 범위가 1 ~ 100,000
        long count = 0;
        int start = 0, end = 0;
        
        while (end < N) {
            if (!visited[arr[end]]) {
                visited[arr[end]] = true; // 현재 숫자를 방문 처리
                count += (end - start + 1); // start부터 end까지의 모든 부분 수열의 개수를 더함
                end++;
            } else {
                visited[arr[start]] = false; // 중복이 발생하면 start를 이동시킴
                start++;
            }
        }
        
        System.out.println(count);
    }
}
