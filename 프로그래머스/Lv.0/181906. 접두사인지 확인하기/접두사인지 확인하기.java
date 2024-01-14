class Solution {
    public int solution(String my_string, String is_prefix) {
        int answer = 0;
        int count = 0;
        for(int i=0;i<my_string.length();i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<count;j++){
                sb.append(my_string.charAt(j));
            }
            if(is_prefix.equals(sb.toString())){
                answer = 1;
            }
            count++;
        }
        
        return answer;
    }
}