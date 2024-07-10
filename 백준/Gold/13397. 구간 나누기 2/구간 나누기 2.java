import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int[] arr = new int[N];
        
        stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int left = 0;
        int right = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();
        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canDivide(arr, N, M, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean canDivide(int[] arr, int N, int M, int maxScore) {
        int count = 1;
        int minValue = arr[0];
        int maxValue = arr[0];

        for (int i = 1; i < N; i++) {
            minValue = Math.min(minValue, arr[i]);
            maxValue = Math.max(maxValue, arr[i]);

            if (maxValue - minValue > maxScore) {
                count++;
                minValue = arr[i];
                maxValue = arr[i];
            }

            if (count > M) {
                return false;
            }
        }

        return true;
    }
}
