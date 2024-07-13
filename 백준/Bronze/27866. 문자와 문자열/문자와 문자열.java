import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk;

        String str = br.readLine();

        stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());

        bw.write(str.charAt(n-1));
        bw.flush();
        bw.close();
        br.close();
    }
}