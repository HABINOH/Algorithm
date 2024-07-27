import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    static int n;
    static List<String> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            n = Integer.parseInt(br.readLine());
            results = new ArrayList<>();
            dfs(1, 1, "1");
            Collections.sort(results);
            for (String result : results) {
                bw.write(result);
                bw.newLine();
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int num, String str) {
        if (depth == n) {
            if (isZero(str)) {
                results.add(str);
            }
            return;
        }
        dfs(depth + 1, num + 1, str + " " + (num + 1));
        dfs(depth + 1, num + 1, str + "+" + (num + 1));
        dfs(depth + 1, num + 1, str + "-" + (num + 1));
    }

    static boolean isZero(String s) {
        String cleanedStr = s.replace(" ", "");
        int sum = 0;
        int num = 0;
        int sign = 1; // 1 for '+', -1 for '-'

        for (int i = 0; i < cleanedStr.length(); i++) {
            char ch = cleanedStr.charAt(i);
            if (ch == '+') {
                sum += sign * num;
                num = 0;
                sign = 1;
            } else if (ch == '-') {
                sum += sign * num;
                num = 0;
                sign = -1;
            } else {
                num = num * 10 + (ch - '0');
            }
        }
        sum += sign * num;
        return sum == 0;
    }
}
