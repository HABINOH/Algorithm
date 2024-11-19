import java.io.*;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        ArrayDeque<Double> deque = new ArrayDeque<>();
        double[] arr = new double[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        for (int i = 0; i < str.length(); i++) {
            char chr = str.charAt(i);
            double result =0;
            if (chr - 65 >= 0 && chr - 65 <= 26) {
                deque.push(arr[chr - 65]);
            } else {
                double a = deque.pop();
                double b = deque.pop();
                if (chr == '+') {
                    result = b+a;
                    deque.push(result);
                } else if (chr == '*') {
                    result = b*a;
                    deque.push(result);
                } else if (chr == '-') {
                    result = b-a;
                    deque.push(result);
                } else if (chr == '/') {
                    result = b/a;
                    deque.push(result);
                }
            }
        }
        bw.write(String.format("%.2f", deque.pollLast()));
        bw.flush();
        bw.close();
    }
}