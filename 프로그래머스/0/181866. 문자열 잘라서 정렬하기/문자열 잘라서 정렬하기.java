import java.util.*;
class Solution {
    public ArrayList solution(String myString) {
        ArrayList<String> answer = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(myString, "x");
        while(stk.hasMoreTokens()){
            answer.add(stk.nextToken());
        }
        Collections.sort(answer);
        return answer;
    }
}