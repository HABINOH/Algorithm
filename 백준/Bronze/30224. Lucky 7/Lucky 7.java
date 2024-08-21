import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Long> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        String num = stk.nextToken();
        if(!num.contains("7")){
            int number = Integer.parseInt(num);
            if(number%7 != 0){
                bw.write("0");
            }else{
                bw.write("1");
            }
        }else{
            int number = Integer.parseInt(num);
            if(number%7 != 0){
                bw.write("2");
            }else{
                bw.write("3");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
