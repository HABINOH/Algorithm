import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long x = Long.parseLong(st.nextToken());
        long y = Long.parseLong(st.nextToken());
        long w = Long.parseLong(st.nextToken());  //평행이동시간
        long s = Long.parseLong(st.nextToken());  //대각선이동시간

        long temp1,temp2,temp3;
        temp1 = (x+y) * w; //평행이동
        temp2 = 0;
        if((x+y) % 2 == 0){
                temp2 = Math.max(x,y) * s;
        }else{
            temp2 = (Math.max(x,y) - 1) * s + w;
        }

        temp3 = (Math.min(x, y))*s+(Math.abs(x-y))*w;

        System.out.println(Math.min(temp1, Math.min(temp2, temp3)));
    }
}