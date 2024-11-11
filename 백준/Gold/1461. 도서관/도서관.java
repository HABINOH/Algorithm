import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] nodes;
    static boolean[] isFan;
    static boolean[] visited;
    static boolean answer = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        ArrayList<Integer> positive = new ArrayList<>();
        ArrayList<Integer> negative = new ArrayList<>();

        int maxPos = 0;
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int pos = Integer.parseInt(stk.nextToken());
            int absPos = Math.abs(pos);

            if(pos > 0){positive.add(pos);}
            else{negative.add(pos);}

            maxPos = Math.max(maxPos, absPos);
        }

        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);

        int answer = 0;
        for(int i=0; i<positive.size(); i+=m){
            answer += positive.get(i) * 2;
        }
        for(int i=0; i<negative.size(); i+=m){
            answer += Math.abs(negative.get(i)) * 2;
        }

        answer -= maxPos;

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
