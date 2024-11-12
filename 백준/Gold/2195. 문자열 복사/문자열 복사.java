import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] nodes;
    static boolean[] isFan;
    static boolean[] visited;
    static boolean answer = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer stk = new StringTokenizer(br.readLine());

        String s = br.readLine();
        String p = br.readLine();

        int idx = 0;
        int cnt = 0;
        for (int i = 0; i < p.length(); i++) {
            String subString = p.substring(idx, i+1);

            if (!s.contains(subString)) {
                cnt++;
                idx = i;
            }
        }

        bw.write(String.valueOf(cnt+1));
        bw.flush();
        bw.close();
        br.close();
    }
}
