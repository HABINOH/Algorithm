import java.util.*;
class Solution {
    static int INF = Integer.MAX_VALUE;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = INF;
        int len = fares.length;
        int[][] graph = new int[n+1][n+1];
        
        for(int i=0;i<=n;i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for(int i=1;i<=n;i++){
            graph[i][i] = 0;
        }
        
        for (int[] fare : fares) {
            int i = fare[0];
            int j = fare[1];
            int dis = fare[2];
            graph[i][j] = dis;
            graph[j][i] = dis;
        }
        
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(graph[i][k] != INF && graph[k][j] != INF) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
        
        
        for(int i=1;i<=n;i++){
            if(graph[s][i] != INF && graph[i][a] != INF && graph[i][b] != INF) {
                answer = Math.min(graph[s][i] + graph[i][a] + graph[i][b], answer);
            }
        }
        
        return answer;
    }
}