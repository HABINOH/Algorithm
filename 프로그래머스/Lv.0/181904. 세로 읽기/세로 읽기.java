class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        int row = my_string.length() / m;
        char[][] strings = new char[row][m];
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<m;j++){
                strings[i][j] = my_string.charAt(count++);
                if(j+1==c){
                    sb.append(strings[i][j]);
                }
            }
        }
        return sb.toString();
    }
}