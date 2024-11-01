import java.util.*;
import java.io.*;

public class Main {
    static class Edge{
        int from;
        int to;
        int time;
        public Edge(int to, int from, int time){
            this.to = to;
            this.from = from;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(stk.nextToken());
        while(tc --> 0){
            stk = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stk.nextToken());
            int m = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());

            ArrayList<Edge> edges = new ArrayList<>();
            for(int i=0;i<m;i++){
                stk = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(stk.nextToken());
                int e = Integer.parseInt(stk.nextToken());
                int t = Integer.parseInt(stk.nextToken());
                edges.add(new Edge(s,e,t));
                edges.add(new Edge(e,s,t));
            }
            for(int i=0;i<w;i++){
                stk = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(stk.nextToken());
                int e = Integer.parseInt(stk.nextToken());
                int t = Integer.parseInt(stk.nextToken());
                edges.add(new Edge(s,e,-t));
            }

            boolean hasNegativeCycle = false;
            for(int i=1;i<=n;i++){
                if(bellmanFord(edges, n, i)){
                    hasNegativeCycle = true;
                    break;
                }
            }
            bw.write(hasNegativeCycle ? "YES" : "NO");
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static boolean bellmanFord(ArrayList<Edge> edges, int n, int start){
        int[] dist = new int[n+1];
        final int INF = Integer.MAX_VALUE;
        Arrays.fill(dist, INF);

        dist[start] = 0;

        for(int i=1;i<n;i++){
            boolean update = false;
            for(Edge edge : edges){
                if(dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.time){
                    dist[edge.to] = dist[edge.from] + edge.time;
                    update = true;
                }
            }
            if(!update){break;}
        }

        for(Edge edge : edges){
            if(dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.time){
                return true;
            }
        }

        return false;
    }
}
