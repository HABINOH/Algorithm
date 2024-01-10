import java.util.*;
class Solution {
    public int[] solution(int start_num, int end_num) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=start_num; i<=end_num; i++){
            list.add(i);
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}