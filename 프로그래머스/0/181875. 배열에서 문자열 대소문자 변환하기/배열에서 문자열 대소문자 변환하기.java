import java.util.*;
class Solution {
    public ArrayList solution(String[] strArr) {
        ArrayList<String> answer = new ArrayList<>();
        for(int i=0;i<strArr.length;i++){
            String str = new String();
            if(i%2==1){
                str = strArr[i].toUpperCase();
            }else{
                str = strArr[i].toLowerCase();
            }
            answer.add(str);
        }
        return answer;
    }
}