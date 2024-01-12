class Solution {
    public String solution(String my_string, int n) {
        StringBuilder sb = new StringBuilder();
        int len = my_string.length();
        int start = len - n;
        for(int i=start; i<len; i++){
            sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }
}