import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String standardStr = br.readLine();
        String boomStr = br.readLine();
        int boomLen = boomStr.length();

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<standardStr.length();i++){
            sb.append(standardStr.charAt(i));
            //폭발 문자열과 일치하는 부분을 찾는 로직
            if(sb.length() >= boomLen){
                boolean isBoom = true;
                for(int j=0;j<boomLen;j++){
                    if(sb.charAt(sb.length() - boomLen + j) != boomStr.charAt(j)){
                        isBoom = false;
                        break;
                    }
                }
                if(isBoom){
                    sb.delete(sb.length() - boomLen, sb.length());
                }
            }
        }
        bw.write(sb.length()==0 ? "FRULA" : sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
