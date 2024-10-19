import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        String[] line = br.readLine().split("");
        boolean[] visited = new boolean[n];
        int answer = 0;
        for(int i=0; i<n; i++){
            if(line[i].equals("P")) {
                int startIndex = Math.max(i-k,0);
                int endIndex = Math.min(i+k,n-1);
                for(int j=startIndex; j<=endIndex; j++){
                    if(line[j].equals("H") && !visited[j]){
                        visited[j] = true;
                        answer++;
                        break;
                    }
                }
            }
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
