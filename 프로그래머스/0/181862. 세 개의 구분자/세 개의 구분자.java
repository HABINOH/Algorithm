import java.util.*;
class Solution {
    public ArrayList solution(String myStr) {
        ArrayList<String> answer = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(myStr, "abc");
        
        while(stk.hasMoreTokens()){
            answer.add(stk.nextToken());
        }
        
        if(answer.size() == 0){
            answer.add("EMPTY");
        }
    
        return answer;
    }
}