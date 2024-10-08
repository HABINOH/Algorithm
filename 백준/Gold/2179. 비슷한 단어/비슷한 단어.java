import java.io.*;
import java.util.*;

public class Main {
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = br.readLine();
        }

        String resultWordOne = "";
        String resultWordTwo = "";
        int maxLength = 0;

        for(int i=0;i<n-1;i++){
            if(maxLength >= words[i].length()){continue;}
            for(int j=i+1;j<n;j++){
                if(maxLength >= words[j].length()){continue;}
                int prefixLength = check(words[i], words[j]);
                if(maxLength < prefixLength){
                    maxLength = prefixLength;
                    resultWordOne = words[i];
                    resultWordTwo = words[j];
                }
            }
        }
        bw.write(resultWordOne + "\n");
        bw.write(resultWordTwo);
        bw.flush();
        bw.close();
        br.close();
    }
    static int check(String str1, String str2){
        int len = Math.min(str1.length(), str2.length());
        int count = 0;
        for(int i=0;i<len;i++){
            if(str1.charAt(i) == str2.charAt(i)){
                count++;
            }else{break;}
        }
        return count;
    }
}
