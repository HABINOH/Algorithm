import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Meat> pq = new PriorityQueue<>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            pq.add(new Meat(weight, price));
            total += weight;
        }
        if (total < m) {
            System.out.println(-1);
            return;
        }

        int beforePrice = 0;
        int weightSum = 0;
        int priceSum = 0;
        int result = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Meat cur = pq.poll();
            weightSum += cur.weight;

            if (beforePrice != cur.price) {
                priceSum = beforePrice = cur.price;
            } else {
                priceSum += cur.price;
            }

            if (weightSum >= m) {
                result = Math.min(result, priceSum);
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}

class Meat implements Comparable<Meat> {
    int weight;
    int price;

    public Meat(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Meat meat) {
        if (this.price == meat.price)
            return meat.weight - this.weight;
        return this.price - meat.price;
    }
}