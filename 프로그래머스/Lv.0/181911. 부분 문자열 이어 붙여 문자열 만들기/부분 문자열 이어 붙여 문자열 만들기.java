class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<my_strings.length;i++){
            for(int j=parts[i][0]; j<=parts[i][1]; j++){
                sb.append(my_strings[i].charAt(j));
            }
        }
        answer = sb.toString();
        return answer;
    }
}