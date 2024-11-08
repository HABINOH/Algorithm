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

        nodes = new ArrayList[n+1];
        isFan = new boolean[n+1];
        visited = new boolean[n+1];

        for(int i=0;i<n+1;i++){
            nodes[i] = new ArrayList<>();
        }

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stk.nextToken());
            int to = Integer.parseInt(stk.nextToken());
            nodes[from].add(to);
        }

        int fanNum = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<fanNum;i++){
            int fan = Integer.parseInt(stk.nextToken());
            isFan[fan] = true;
        }

        dfs(1, isFan[1]);

        bw.write(answer ? "Yes" : "yes");
        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int go, boolean isMeet){
        if(nodes[go].isEmpty()){
            if(!isMeet){answer = false;}
        }

        for(int next : nodes[go]){
            if(!visited[next]){
                visited[next] = true;
                if(isFan[next]){
                    dfs(next, true);
                }else{
                    dfs(next, isMeet);
                }
                visited[next] = false;
            }
        }
    }
}
