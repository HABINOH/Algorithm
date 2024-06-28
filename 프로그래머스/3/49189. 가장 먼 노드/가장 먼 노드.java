import java.util.*;
class Solution {
    ArrayList<Integer> list[];
    int[] visited;
    int len;
    int maxDist;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        //초기화
        len = edge.length;
        list = new ArrayList[len+1];
        for(int i=0;i<=len;i++){
            list[i] = new ArrayList<>();
        }
        for(int i=0;i<len;i++){
            list[edge[i][0]].add(edge[i][1]);
            list[edge[i][1]].add(edge[i][0]);
        }
        
        bfs();
        
        for(int i=0;i<len;i++){
            if(maxDist == visited[i]){
                answer++;
            }
        }
        
        return answer;
    }
    public int[] bfs(){
        Queue<Integer> que = new LinkedList<>();
        visited = new int[len+1];
        que.offer(1);
        visited[1] = 1;
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int next : list[cur]){
                if(visited[next] == 0){
                    visited[next] = visited[cur] + 1;
                    maxDist = Math.max(visited[next], maxDist);
                    que.offer(next);
                }
            }
        }
        return visited;
    }
}