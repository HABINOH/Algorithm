class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        int len = my_string.length();
        int count = 1;
        for(int i=0;i<len;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=len-count;j<len;j++){
                sb.append(my_string.charAt(j));
            }
            if(sb.toString().equals(is_suffix)){
                answer = 1;
            }
            count++;
        }
        return answer;
    }
}