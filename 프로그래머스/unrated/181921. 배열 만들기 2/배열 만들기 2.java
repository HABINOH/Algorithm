import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=l; i<=r; i++){
            String s = Integer.toString(i);
            int cnt = 0;
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<s.length(); j++){
                if(s.charAt(j) == '5' || s.charAt(j) == '0'){
                    sb.append(s.charAt(j)); 
                    cnt++;
                }
            }
            if(cnt == s.length()){
                list.add(Integer.parseInt(sb.toString()));
            }
        }
        if(list.size() == 0){list.add(-1);}
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}