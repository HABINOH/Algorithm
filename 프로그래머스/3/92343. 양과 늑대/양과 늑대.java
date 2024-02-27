import java.util.*;
class Solution {
    int[] node;
    ArrayList<ArrayList<Integer>> graph;
    int maxS;
    boolean[][][] visited = new boolean[17][18][18];
    public int solution(int[] info, int[][] edges) {
        this.node = info;
        
        int len = node.length;
        
        //그래프 초기화
        graph = new ArrayList();
        for(int i=0;i<len;i++)
            graph.add(new ArrayList<>());
        
        for(int[] edge : edges){ //양 방향 그래프 형성
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        dfs(0,0,0);
        
        return maxS;
    }
    public void dfs(int pos, int s, int w){
        //방문 했던 곳이면 순회X
        if(visited[pos][s][w]) return;
        
        //방문 표시
        visited[pos][s][w] = true;
        
        int backupS = s;
        int backupW = w;
        int backupN = node[pos];
        
        if(node[pos] == 0){s++;} //양 개수 증가
        else if(node[pos] == 1){w++;} //늑대 개수 증가
        
        node[pos] = -1; //양 늑대 아무도 없는 노드로 바꿈
        
        if(s > w){ //양이 더 커야지 순회가능
            maxS = Math.max(maxS, s); //최대로 양 먹을 수 있는 개수
            for(int next : graph.get(pos))
                dfs(next,s,w);
        }
        node[pos] = backupN; //본래 양 늑대 노드로 되돌림
        visited[pos][backupS][backupW] = false; //방문 표시 제거
    }
}