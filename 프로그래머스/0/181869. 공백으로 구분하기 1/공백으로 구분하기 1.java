import java.util.*;
class Solution {
    public ArrayList solution(String my_string) {
        ArrayList<String> answer = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(my_string, " ");
        while(stk.hasMoreTokens()){
            answer.add(stk.nextToken());
        }
        return answer;
    }
}