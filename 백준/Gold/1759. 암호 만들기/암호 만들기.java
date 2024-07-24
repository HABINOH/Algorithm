import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int l = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        String[] str = new String[c];
        for(int i=0;i<c;i++){
            str[i] = stk.nextToken();
        }

        Arrays.sort(str);

        dfs(0, 0, str, l);

        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int start, int depth, String[] str, int l) throws IOException {
        if(depth==l){
            if(isValid(sb.toString())){
                bw.write(sb.toString());
                bw.newLine();
            }
            return;
        }
        for(int i=start;i<str.length;i++){
            sb.append(str[i]);
            dfs(i + 1, depth + 1, str, l);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    static boolean isValid(String checkStr){ //최소 모음 1개, 자음 2개
        int mo = 0;
        int ja = 0;
        for(int i=0;i<checkStr.length();i++){
            char check = checkStr.charAt(i);
            if(check == 'a' || check == 'e' || check == 'i' || check == 'o' || check == 'u'){
                mo++;
            }else{
                ja++;
            }
        }
        return mo >= 1 && ja >= 2;
    }
}