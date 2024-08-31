import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Long solution = 0L;

        PriorityQueue<Long> queue = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            queue.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < M ; i++) {
            Long tempA = queue.poll();
            Long tempB = queue.poll();

            queue.add(tempA+tempB);
            queue.add(tempA+tempB);
        }

       while(!queue.isEmpty()){
           solution += queue.poll();
       }
        System.out.println(solution);

    }
}