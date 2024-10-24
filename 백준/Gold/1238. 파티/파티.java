import java.util.*;
import java.io.*;

public class Main {
    static class Node implements Comparable<Node> {
        int to;
        int dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    static ArrayList<Node>[] roads;
    static ArrayList<Node>[] reverseRoads;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken()); // 노드 수
        int m = Integer.parseInt(stk.nextToken()); // 도로 수
        int end = Integer.parseInt(stk.nextToken()); // 목표 지점

        roads = new ArrayList[n + 1]; // 노드에 대응하는 리스트
        reverseRoads = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            roads[i] = new ArrayList<>();
            reverseRoads[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int dist = Integer.parseInt(stk.nextToken());

            roads[from].add(new Node(to, dist));         // 정방향 그래프
            reverseRoads[to].add(new Node(from, dist)); // 역방향 그래프
        }

        int[] dist1 = dijkstra(roads, end);
        int[] dist2 = dijkstra(reverseRoads, end);

        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist1[i] != Integer.MAX_VALUE && dist2[i] != Integer.MAX_VALUE) {
                answer = Math.max(answer, dist1[i] + dist2[i]);
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] dijkstra(ArrayList<Node>[] road, int start) {
        int[] dist = new int[road.length];
        Arrays.fill(dist, Integer.MAX_VALUE); // 거리 무한대로 초기화
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            for (Node next : road[curNode.to]) {
                if (dist[next.to] > dist[curNode.to] + next.dist) {
                    dist[next.to] = dist[curNode.to] + next.dist;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist;
    }
}
