import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine().trim());
        }
        Arrays.sort(a);

        ArrayList<Integer> twoSum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                twoSum.add(a[i] + a[j]);
            }
        }
        Collections.sort(twoSum);

        // 배열의 큰 값부터 후보를 선택하여 조건을 만족하는지 검사
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                int target = a[i] - a[j];
                if (Collections.binarySearch(twoSum, target) >= 0) {
                    System.out.println(a[i]);
                    return;
                }
            }
        }
    }
}
