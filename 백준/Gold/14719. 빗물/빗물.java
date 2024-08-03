import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());

        int[] bluck = new int[w];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<w;i++){
            bluck[i] = Integer.parseInt(stk.nextToken());
        }
        int result = 0;
        for(int i=1;i<w-1;i++){
            int current = bluck[i];

            int left = 0;
            for(int j=0;j<=i;j++){
                left = Math.max(left, bluck[j]);
            }

            int right = 0;
            for(int j=i;j<w;j++){
                right = Math.max(right, bluck[j]);
            }
            result += Math.min(left, right) - current;
        }
        if(result < 0){result = 0;}
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

}
