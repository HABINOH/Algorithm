import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Long> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        if(n <= 10){
            bw.write(String.valueOf(n));
        }else if(n >= 1023){
            bw.write("-1");
        }else{
            for(int i=0;i<10;i++){
                dfs(i);
            }
            Collections.sort(answer);
            bw.write(String.valueOf(answer.get(n)));
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(long num){
        answer.add(num);
        long modNum = num % 10;
        if(modNum == 0){
            return;
        }
        for(long i=modNum-1; i>=0; i--){
            long number = num * 10 + i;
            dfs(number);
        }
    }
}
