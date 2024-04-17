import java.util.*;
class Solution {
    int[] node;
    ArrayList<ArrayList<Integer>> graph;
    boolean[][][] visited = new boolean[18][18][18];
    int answer = 0;
    public int solution(int[] info, int[][] edges) {
        node = info;
        int len = info.length;
        //그래프 초기화
        graph = new ArrayList<>();
        for(int i=0;i<len;i++){
            graph.add(new ArrayList<>());
        }
        //그래프 연결
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        dfs(0,0,0);
        
        return answer;
    }
    public void dfs(int pos, int sheep, int wolf){
        //방문 한 곳이면 방문 X
        if(visited[pos][sheep][wolf]){return;}
        //방문 체크
        visited[pos][sheep][wolf] = true;
        
        int backUpPos = node[pos];
        int backUpSheep = sheep;
        int backUpWolf = wolf;
        
        //노드 값에 따라서 양과 늑대 개수 카운트
        if(node[pos] == 0){sheep++;}
        else if(node[pos] == 1){wolf++;}
        
        //늑대 노드에 -1 값 넣어주기(양도 늑대도 아님)
        node[pos] = -1;
        
        //내가 먹은 양의 개수가 더 클 때만 반복 허용
        if(sheep > wolf){
            answer = Math.max(answer, sheep);
            for(int next : graph.get(pos))
                dfs(next, sheep, wolf);
        }
        node[pos] = backUpPos;
        visited[pos][backUpSheep][backUpWolf] = false;
    }
    
}

//edges로 들어온 그래프를 형성한다.
//info에 따라서 edges로 들어온 그래프에 값을 넣어준다.
//dfs
//방문 여부를 체크한다.
//노드 값 변경 후 되돌리기 위해 backup 정보 저장
//늑대를 먹었는지, 양을 먹었는지 카운트
//양 먹은게 더 클 때만 dfs 들어간다. (이때, 먹은 양의 개수 최대 값을 갱신한다.)
//dfs 끝날 때 방문 여부 false, 노드 값 backup

/*
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
*/
