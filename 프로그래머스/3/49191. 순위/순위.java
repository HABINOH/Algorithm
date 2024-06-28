class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] graph = new int[n+1][n+1];
        //2차원 배열로 초기화
        for(int i=0;i<results.length;i++){
            graph[results[i][0]][results[i][1]] = 1;
        }
        //플로이드-워셜
        for(int k=0;k<=n;k++){
            for(int i=0;i<=n;i++){
                for(int j=0;j<=n;j++){
                    if(graph[i][k] == 1 && graph[k][j] == 1){
                        graph[i][j] = 1;
                    }
                }
            }
        }
        
        for(int i=1;i<=n;i++){
            int game = 0;
            for(int j=1;j<=n;j++){
                //관계가 존재하면 게임 결과가 있다는 것
                if(graph[i][j] == 1 || graph[j][i] == 1){
                    game++;
                }
            }
            //게임 결과가 모두 존재한다면 (자기 빼고 인원 수) 결과 값 +1
            if(game == n-1){
                answer++;
            }
        }
        
        return answer;
    }
}