import java.io.*;
import java.util.*;

public class Main {
    static String S;
    static String T;
    static boolean result = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = br.readLine();
        T = br.readLine();

        dfs(T);
        if(result){
            bw.write("1");
        }else{
            bw.write("0");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(String alphabet){
        if(result){return;}
        if(alphabet.length() == S.length()){
            result = alphabet.equals(S);
            return;
        }
        // 맨 뒤 A -> A 제거
        if(!alphabet.isEmpty() && alphabet.charAt(alphabet.length()-1) == 'A'){
            dfs(alphabet.substring(0, alphabet.length()-1));
        }
        // 맨 뒤 B -> B 제거 후 뒤집기
        if(!alphabet.isEmpty() && alphabet.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder(alphabet.substring(1));
            dfs(sb.reverse().toString());
        }
    }
}
