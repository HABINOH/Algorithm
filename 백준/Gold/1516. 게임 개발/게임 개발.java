import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] buildTime;
    static int[] dp;
    static int[] inDegree;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        buildTime = new int[n+1];
        dp = new int[n+1];
        inDegree = new int[n+1];

        graph = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1;i<=n;i++){
            stk = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(stk.nextToken());
            dp[i] = buildTime[i];

            while(true){
                int preBuilding = Integer.parseInt(stk.nextToken());
                if(preBuilding == -1){break;}
                graph[preBuilding].add(i);
                inDegree[i]++;
            }
        }

        bfs();

        for(int i=1;i<=n;i++){
            bw.write(String.valueOf(dp[i]));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){
            int cur = queue.poll();

            for(int next : graph[cur]){
                dp[next] = Math.max(dp[next], dp[cur] + buildTime[next]);
                inDegree[next]--;

                if(inDegree[next] == 0){
                    queue.offer(next);
                }
            }
        }
    }
}
