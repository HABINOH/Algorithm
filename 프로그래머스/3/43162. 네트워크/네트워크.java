class Solution {
    boolean[] visited = new boolean[201];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int comSize = computers.length;
        //전체 노드 수 만큼 반복
        for(int i=0;i<comSize;i++){
            //방문되어있는지 확인
            if(visited[i]){continue;}
            dfs(i, computers, n);
            answer++;
        }
        
        //총 DFS 반복한 횟수 반환
        return answer;
    }
    public void dfs(int node, int[][] computers, int n){
        //한 노드마다 연결되어 있는 노드 방문하면서 방문 체크
        if(visited[node]){return;}
        visited[node] = true;
        for(int i=0;i<n;i++){
            if(computers[node][i] == 1){
                dfs(i, computers, n);
            }
        }
    }
}