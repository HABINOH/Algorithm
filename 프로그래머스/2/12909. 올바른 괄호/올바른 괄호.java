import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> stack = new ArrayDeque<>();
        boolean dir = false;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    answer = false;
                }else{
                    if(stack.pop() != '('){
                        answer = false;
                    }
                }
            }
        }
        if(stack.size() != 0){answer = false;}

        return answer;
    }
}