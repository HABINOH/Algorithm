import java.io.*;
import java.util.*;

public class Main {
    static boolean[] broken = new boolean[10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(br.readLine());

        if(m>0){
            stk = new StringTokenizer(br.readLine());
            for(int i=0;i<m;i++){
                broken[Integer.parseInt(stk.nextToken())] = true;
            }
        }

        int result = Math.abs(n - 100); // +, -로만 이동
        for(int channel=0; channel<=999999; channel++){
            int len = canPress(channel);
            if(len > 0){
                int press = len + Math.abs(channel - n);
                result = Math.min(result, press);
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    static int canPress(int channel){ //채널 번호를 누를 수 있으면 자릿 수 반환, 아니면 0을 반환
        if(channel == 0) {
            if (broken[0]) {return 0;}
            else {return 1;}
        }
        int len = 0;
        while(channel > 0){
            int digit = channel % 10;
            if(broken[digit]){return 0;}
            len++;
            channel /= 10;
        }
        return len;
    }
}
