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
    static ArrayList<Node>[] graph;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        dist = new int[n+1];
        for(int i=0;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dijkstra(1);
        bw.write(String.valueOf(dist[n]));
        bw.flush();
        bw.close();
        br.close();
    }
    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((c1,c2) -> c1.weight- c2.weight);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] < now.weight){
                continue;
            }
            for(Node next : graph[now.to]){
                if(dist[next.to] > next.weight + dist[now.to]){
                    dist[next.to] = next.weight + dist[now.to];
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }
}