import java.util.*;
class Solution {
    boolean[] visited;
    ArrayList<String> answer;
    public String[] solution(String[][] tickets) {
        //갈 수 있는 여행 경로에 대해서 다 구해보자
        answer = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs(0, tickets, "ICN", "ICN");
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }
    public void dfs(int depth, String[][] tickets, String pre, String result){
        if(tickets.length == depth){
            answer.add(result);
            return;
        }
        
        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(pre)){
                visited[i] = true;
                dfs(depth+1, tickets, tickets[i][1], result + " " + tickets[i][1]);
                visited[i] = false;
            }
        }
    }
}