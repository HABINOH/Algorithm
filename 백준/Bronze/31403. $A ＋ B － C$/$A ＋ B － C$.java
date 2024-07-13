import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String s = "";
        s += a;
        s += b;

        System.out.println(a + b - c);
        System.out.println(Integer.parseInt(s) - c);
    }
}