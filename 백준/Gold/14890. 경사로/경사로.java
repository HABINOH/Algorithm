import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static boolean[] slopeInstalled;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        int count = 0;

        // 가로 방향 검사
        for (int i = 0; i < n; i++) {
            if (canPlaceSlopeRow(i, n, l)) {
                count++;
            }
        }

        // 세로 방향 검사
        for (int j = 0; j < n; j++) {
            if (canPlaceSlopeCol(j, n, l)) {
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean canPlaceSlopeRow(int row, int n, int l) {
        slopeInstalled = new boolean[n]; // 경사로 설치 여부 배열

        for (int i = 0; i < n - 1; i++) {
            int currentHeight = map[row][i];
            int nextHeight = map[row][i + 1];
            int diff = currentHeight - nextHeight;

            if (diff == 1) { // 앞보다 뒤가 낮은 경우 (경사로를 뒤에 설치)
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || slopeInstalled[i + j] || map[row][i + j] != nextHeight) {
                        return false;
                    }
                }
                for (int j = 1; j <= l; j++) {
                    slopeInstalled[i + j] = true;
                }
                i += l - 1;
            } else if (diff == -1) { // 앞보다 뒤가 높은 경우 (경사로를 앞에 설치)
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || slopeInstalled[i - j] || map[row][i - j] != currentHeight) {
                        return false;
                    }
                }
                for (int j = 0; j < l; j++) {
                    slopeInstalled[i - j] = true;
                }
            } else if (Math.abs(diff) > 1) {
                return false; // 차이가 1보다 큰 경우 경사로 설치 불가
            }
        }

        return true;
    }

    static boolean canPlaceSlopeCol(int col, int n, int l) {
        slopeInstalled = new boolean[n]; // 경사로 설치 여부 배열

        for (int i = 0; i < n - 1; i++) {
            int currentHeight = map[i][col];
            int nextHeight = map[i + 1][col];
            int diff = currentHeight - nextHeight;

            if (diff == 1) { // 위보다 아래가 낮은 경우 (경사로를 아래에 설치)
                for (int j = 1; j <= l; j++) {
                    if (i + j >= n || slopeInstalled[i + j] || map[i + j][col] != nextHeight) {
                        return false;
                    }
                }
                for (int j = 1; j <= l; j++) {
                    slopeInstalled[i + j] = true;
                }
                i += l - 1;
            } else if (diff == -1) { // 위보다 아래가 높은 경우 (경사로를 위에 설치)
                for (int j = 0; j < l; j++) {
                    if (i - j < 0 || slopeInstalled[i - j] || map[i - j][col] != currentHeight) {
                        return false;
                    }
                }
                for (int j = 0; j < l; j++) {
                    slopeInstalled[i - j] = true;
                }
            } else if (Math.abs(diff) > 1) {
                return false; // 차이가 1보다 큰 경우 경사로 설치 불가
            }
        }

        return true;
    }
}
