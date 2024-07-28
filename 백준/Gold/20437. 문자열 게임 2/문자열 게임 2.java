import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            sliceWindow(w, k);
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static void sliceWindow(String w, int k) throws IOException {
        if(k==1){
            bw.write("1 1");
            bw.newLine();
            return;
        }
        int[] alpha = new int[26];
        for(int i=0;i<w.length();i++){
            alpha[w.charAt(i) - 'a']++;
        }
        int min = Integer.MAX_VALUE;
        int max = -1;

        for(int i=0;i<w.length();i++){
            if(alpha[w.charAt(i) - 'a'] < k){
                continue;
            }
            //바로 뒤 문자열 비교
            int cnt = 1;
            for(int j=i+1; j<w.length(); j++){
                if(w.charAt(i) == w.charAt(j)){
                    cnt++;
                }
                if(cnt == k){ // k개 문자의 수가 된다면
                    min = Math.min(min, j-i+1);
                    max = Math.max(max, j-i+1);
                    break;
                }
            }
        }
        if(min == Integer.MAX_VALUE || max == -1){
            bw.write("-1");
            bw.newLine();
            return;
        }
        bw.write(min + " " + max);
        bw.newLine();
    }
}
