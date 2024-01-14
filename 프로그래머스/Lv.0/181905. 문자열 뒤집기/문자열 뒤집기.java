class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder(my_string);
        while(s<e){
            char temp = sb.charAt(s);
            sb.setCharAt(s, sb.charAt(e));
            sb.setCharAt(e, temp);
            s++;
            e--;
        }
        
        
        return sb.toString();
    }
}