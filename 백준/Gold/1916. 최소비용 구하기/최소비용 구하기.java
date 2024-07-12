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
    static int n;
    static boolean[] visited;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk;

        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        dist = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int en = Integer.parseInt(stk.nextToken());
            int dis = Integer.parseInt(stk.nextToken());

            graph[st].add(new Node(en, dis));
        }
        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        dijkstra(start);
        bw.write(String.valueOf(dist[end]));
        bw.flush();
        bw.close();
        br.close();
    }
    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((c1, c2) -> c1.weight - c2.weight);

        dist[start] = 0;

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.to]) {continue;}
            visited[now.to] = true;

            for(Node next : graph[now.to]){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
    }

}