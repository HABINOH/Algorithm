import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String convertNum = Integer.toString(n, k);
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<convertNum.length();i++){
            if(convertNum.charAt(i) != '0'){
                sb.append(convertNum.charAt(i));
            }else{
                if(sb.length()!=0 && isTrue(sb.toString())){answer++;}
                System.out.println(sb.toString());
                sb = new StringBuilder();
                // if(sb.length()!=0)
                //     sb.delete(0, sb.length()+1);
            }
        }
        if(sb.length() != 0){
            if(isTrue(sb.toString())){answer++;}
        }
        return answer;
    }
    public boolean isTrue(String str){
        if(str.equals("1")){return false;}
        long num = Long.parseLong(str);
        boolean check = true;
        for(long i=2;i<=Math.sqrt(num);i++){
            if(num % i == 0){check = false; break;}
        }
        return check;
    }
}