
import java.util.Arrays;
class Solution {
    public String[] solution(String my_string) {
        int len = my_string.length()-1;
        String[] str = new String[len+1];
        int count = 1;
        for(int i=0;i<my_string.length();i++){
            StringBuilder sb = new StringBuilder();
            for(int j=len-count+1; j<=len; j++){
                sb.append(my_string.charAt(j));
            }
            str[i] = sb.toString();
            count++;
        }
        //str 배열 사전 순 정렬
        Arrays.sort(str);
        
        return str;
    }
}