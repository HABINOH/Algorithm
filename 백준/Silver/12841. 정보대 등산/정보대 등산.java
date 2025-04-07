import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 빠른 입력 처리를 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 지점의 개수 n 입력
        int n = Integer.parseInt(br.readLine().trim());
        
        // 각 배열 생성 (0-indexed 사용)
        int[] cross = new int[n];        // 각 지점의 횡단보도 거리
        int[] left = new int[n - 1];       // 왼쪽 길의 구간 거리
        int[] right = new int[n - 1];      // 오른쪽 길의 구간 거리

        // 횡단보도 거리 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cross[i] = Integer.parseInt(st.nextToken());
        }
        
        // 왼쪽 길 구간 거리 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }
        
        // 오른쪽 길 구간 거리 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }
        
        // 왼쪽 길의 누적합 계산: leftPrefix[i]는 0번째부터 i-1번째 구간까지의 합 (i번 지점에 도달할 때까지)
        long[] leftPrefix = new long[n];
        leftPrefix[0] = 0; // 1번 지점에서는 이미 출발해 있으므로 0
        for (int i = 1; i < n; i++) {
            leftPrefix[i] = leftPrefix[i - 1] + left[i - 1];
        }
        
        // 오른쪽 길의 누적합 계산: rightPrefix[i]는 i번 인덱스부터 마지막 구간까지의 합
        long[] rightPrefix = new long[n];
        rightPrefix[n - 1] = 0; // n번 지점에서는 더 이상 이동할 오른쪽 길이 없음
        for (int i = n - 2; i >= 0; i--) {
            rightPrefix[i] = right[i] + rightPrefix[i + 1];
        }
        
        // 각 지점에서 총 이동 거리 계산 및 최소값, 인덱스 갱신
        long minDistance = Long.MAX_VALUE;
        int bestIndex = -1;  // 0-indexed
        for (int i = 0; i < n; i++) {
            long total = leftPrefix[i] + cross[i] + rightPrefix[i];
            if (total < minDistance) {
                minDistance = total;
                bestIndex = i;
            }
        }
        
        // 결과 출력: 인덱스는 0-indexed이므로 1을 더해 1-indexed로 출력
        System.out.println((bestIndex + 1) + " " + minDistance);
    }
}
