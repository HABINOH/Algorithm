class Solution {
    public String solution(String my_string, String alp) {
        String answer = "";
        for(int i=0;i<my_string.length();i++){
            if(my_string.charAt(i) == alp.charAt(0)){
                answer = answer + Character.toUpperCase(my_string.charAt(i));
            }else{answer = answer + my_string.charAt(i);}
        }
        return answer;
    }
}