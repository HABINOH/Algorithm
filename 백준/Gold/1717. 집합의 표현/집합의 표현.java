import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }

        for(int i=0;i<m;i++){
            stk = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(stk.nextToken());
            int num1 = Integer.parseInt(stk.nextToken());
            int num2 = Integer.parseInt(stk.nextToken());

            if(cmd == 0){union(num1, num2);}
            else{
                if(find(num1) == find(num2)){
                    bw.write("yes");
                    bw.newLine();
                }else{
                    bw.write("no");
                    bw.newLine();
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static void union(int num1, int num2){
        num1 = find(num1);
        num2 = find(num2);

        if(num1 != num2){
            if(num1 < num2){
                parent[num2] = num1;
            }else{
                parent[num1] = num2;
            }
        }
    }
    static int find(int num){
        if(num == parent[num]){
            return num;
        }
        return parent[num] = find(parent[num]);
    }
}
