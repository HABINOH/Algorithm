import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        for(int i=0;i<len;i++){
            if(isTrue(s)){answer++;}
            //s 문자열 바꾸기 앞에꺼를 뒤로
            StringBuilder sb = new StringBuilder(s);
            sb.append(s.charAt(0));
            sb.delete(0,1);
            s = sb.toString();
        }
        return answer;
    }
    public boolean isTrue(String str){
        if(str.charAt(0) == ')' 
           || str.charAt(0) == ']' 
           || str.charAt(0) == '}'){
            return false;
        }
        Stack<Character> st = new Stack<>();
        
        for(int i=0;i<str.length();i++){
            if(st.isEmpty()){
                st.push(str.charAt(i));
            }else if(str.charAt(i) == '(' 
                     || str.charAt(i) == '[' 
                     || str.charAt(i) == '{'){
                st.push(str.charAt(i));
            }
            else{
                if(str.charAt(i) == ')'){
                    if(st.pop() != '('){
                        return false;
                    }
                }else if(str.charAt(i) == ']'){
                    if(st.pop() != '['){
                        return false;
                    }
                }else if(str.charAt(i) == '}'){
                    if(st.pop() != '{'){
                        return false;
                    }
                }
            }
        }
        if(st.isEmpty()){return true;}
        else{return false;}
    }
}

/*
올바른 괄호인지 판단하는 메소드 정의 --> 스택 사용
왼쪽으로 한 칸씩 밀기
*/