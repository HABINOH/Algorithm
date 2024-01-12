import java.util.*;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> list = new ArrayList<>();
        //각, 원소마다
        //intStrs[s] 에서 intStrs[l]까지 문자열을 잘라내 정수로 변환
        //이때, k 보다 큰 수만 배열에 담는다
        for(int i=0;i<intStrs.length;i++){
            StringBuilder sb = new StringBuilder();
            String str = intStrs[i];
            for(int j=s;j<s+l;j++){
                sb.append(str.charAt(j));
            }
            int number = Integer.parseInt(sb.toString());
            if(number > k){
                list.add(number);
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}