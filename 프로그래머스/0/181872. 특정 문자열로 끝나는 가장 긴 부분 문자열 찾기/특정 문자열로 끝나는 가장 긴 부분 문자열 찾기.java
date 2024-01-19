import java.util.*;
class Solution {
    public String solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        int patLen = pat.length();
        int end = 0;
        for(int i=myString.length()-1; i>=0; i--){
            int idx = 0;
            boolean check = false;
            if(myString.charAt(i) != pat.charAt(patLen-1)){continue;}
            for(int j=patLen-1; j>=0; j--){
                if(myString.charAt(i-idx) == pat.charAt(j)){
                    idx++;
                }else{check = true;}
            }
            if(!check){
                end = i; break;
            }
        }
        for(int i=0;i<=end;i++){
            sb.append(myString.charAt(i));
        }
        
        return sb.toString();
    }
}