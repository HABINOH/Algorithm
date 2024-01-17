class Solution {
    public String solution(String myString) {
        String answer = "";
        
        for(int i=0;i<myString.length();i++){
            answer = answer + Character.toUpperCase(myString.charAt(i));
        }
        
        return answer;
    }
}