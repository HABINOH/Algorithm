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
    static int m;
    static int[] route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stk.nextToken());

        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            int dis = Integer.parseInt(stk.nextToken());

            graph[from].add(new Node(to, dis));
        }

        stk = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stk.nextToken());
        int end = Integer.parseInt(stk.nextToken());

        route = new int[n+1];
        bw.write(dijkstra(start, end) + "\n");

        Deque<Integer> path = new ArrayDeque<>();
        path.addLast(end);
        while(route[end] != 0){
            path.addLast(route[end]);
            end = route[end];
        }

        bw.write(path.size() + "\n");

        while(!path.isEmpty()){
            bw.write(path.pollLast() + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>((c1, c2) -> c1.weight - c2.weight);
        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        route[start] = 0;
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(dist[now.to] < now.weight){
                continue;
            }
            for(Node next : graph[now.to]){
                if(dist[next.to] > dist[now.to] + next.weight){
                    dist[next.to] = dist[now.to] + next.weight;
                    route[next.to] = now.to;
                    pq.add(new Node(next.to, dist[next.to]));
                }
            }
        }
        return dist[end];
    }
}