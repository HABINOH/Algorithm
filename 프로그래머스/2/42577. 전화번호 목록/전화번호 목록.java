import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i=1;i<phone_book.length;i++){
            String str = phone_book[i-1];
            if(phone_book[i].startsWith(str)){
                answer = false;
                break;
            }
        }
        return answer;
    }
}