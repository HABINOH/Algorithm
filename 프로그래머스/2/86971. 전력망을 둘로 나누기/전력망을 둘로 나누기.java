import java.util.*;
class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int answer = Integer.MAX_VALUE;
    static int[][] copyWires;
    static int copyN;
    public int solution(int n, int[][] wires) {
        copyWires = wires;
        copyN = n;
        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] wire : wires){
            int st = wire[0];
            int en = wire[1];    
            graph[st].add(en);
            graph[en].add(st);
        }
        visited = new boolean[n+1];
        for(int i=0;i<n-1;i++){
            visited[1] = true;
            dfs(1, i);
            check();
            visited = new boolean[n+1];
        }
        return answer;
    }
    static void dfs(int go, int removeRoad){
        // System.out.println(removeRoad + " : " + go);
        for(int next : graph[go]){
            if(next == copyWires[removeRoad][0] || next == copyWires[removeRoad][1]){
                continue;
            }else if(visited[next]){
                continue;
            }else{
                visited[next] = true;
                dfs(next, removeRoad);
            }
        }
    }
    static void check(){
        int topOne = 0;
        for(int i=1;i<=copyN;i++){
            if(visited[i]){
                topOne++;
            }
        }
        int topTwo = copyN - topOne;
        // System.out.println("topOne : " + topOne + ", topTwo : " + topTwo);
        answer = Math.min(answer, Math.abs(topOne - topTwo));
    }
}