import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int to;
        int weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    static final int INF = 200_000_000;
    static int n;
    static int e;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());
        e = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<e;i++){
            stk = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stk.nextToken());
            int v = Integer.parseInt(stk.nextToken());
            int dis = Integer.parseInt(stk.nextToken());
            graph[u].add(new Node(v, dis));
            graph[v].add(new Node(u, dis));
        }
        stk = new StringTokenizer(br.readLine());
        int restAreaOne = Integer.parseInt(stk.nextToken());
        int restAreaTwo = Integer.parseInt(stk.nextToken());

        int firstRoute = dijkstra(1, restAreaOne) + dijkstra(restAreaOne, restAreaTwo) + dijkstra(restAreaTwo, n);
        int secondRoute = dijkstra(1, restAreaTwo) + dijkstra(restAreaTwo, restAreaOne) + dijkstra(restAreaOne, n);

        int result = -1;
        if(firstRoute < INF || secondRoute < INF){
            result = Math.min(firstRoute, secondRoute);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>((c1,c2) -> c1.weight - c2.weight);
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF); // 간선 개수(E) 최대값 * 거리(c) = 200,000 * 1,000
        dist[start] = 0;
        pq.add(new Node(start, 0));
        while(!pq.isEmpty()){
            Node now = pq.poll();
            for(Node next : graph[now.to]){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist[end];
    }

}