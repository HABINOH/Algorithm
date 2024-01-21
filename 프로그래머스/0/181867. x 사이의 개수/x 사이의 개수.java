import java.util.*;
class Solution {
    public ArrayList solution(String myString) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<myString.length();i++){
            if(myString.charAt(i) != 'x'){
                sb.append(myString.charAt(i));
            }else{
                strList.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        strList.add(sb.toString());
        for(String list : strList){
            answer.add(list.length());
        }
        
        return answer;
    }
}