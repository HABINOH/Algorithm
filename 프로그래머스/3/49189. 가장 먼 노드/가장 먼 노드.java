import java.util.*;
//Dijkstra 풀이
class Solution{
    class Node implements Comparable<Node>{
        int node;
        int cost;
        
        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node n){
            return cost - n.cost;
        }
    }
    
    
    ArrayList<Integer> list[];
    int len;
    int maxDist;
    public int solution(int n, int[][] edge){
        int answer = 0;
        len = edge.length;
        list = new ArrayList[len+1];
        for(int i=0;i<=len;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<len;i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        int[] dist = dijkstra();
        for(int i=1;i<=len;i++){
            if(dist[i] == maxDist){
                answer++;
            }
        }
        
        return answer;
    }
    public int[] dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[len+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        pq.offer(new Node(1, 0));
        
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            
            if(dist[cur.node] < cur.cost){
                continue;
            }
            
            for(int next : list[cur.node]){
                if(dist[next] > cur.cost + 1){
                    dist[next] = cur.cost + 1;
                    maxDist = Math.max(maxDist, dist[next]);
                    pq.offer(new Node(next, dist[next]));
                }
            }
        }
        
        return dist;
    }
}



//BFS 풀이
// class Solution {
//     ArrayList<Integer> list[];
//     int[] visited;
//     int len;
//     int maxDist;
//     public int solution(int n, int[][] edge) {
//         int answer = 0;
//         //초기화
//         len = edge.length;
//         list = new ArrayList[len+1];
//         for(int i=0;i<=len;i++){
//             list[i] = new ArrayList<>();
//         }
//         for(int i=0;i<len;i++){
//             list[edge[i][0]].add(edge[i][1]);
//             list[edge[i][1]].add(edge[i][0]);
//         }
        
//         bfs();
        
//         for(int i=0;i<len;i++){
//             if(maxDist == visited[i]){
//                 answer++;
//             }
//         }
        
//         return answer;
//     }
//     public int[] bfs(){
//         Queue<Integer> que = new LinkedList<>();
//         visited = new int[len+1];
//         que.offer(1);
//         visited[1] = 1;
//         while(!que.isEmpty()){
//             int cur = que.poll();
//             for(int next : list[cur]){
//                 if(visited[next] == 0){
//                     visited[next] = visited[cur] + 1;
//                     maxDist = Math.max(visited[next], maxDist);
//                     que.offer(next);
//                 }
//             }
//         }
//         return visited;
//     }
// }