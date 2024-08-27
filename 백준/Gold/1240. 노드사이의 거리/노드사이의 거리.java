import java.io.*;
import java.util.*;


public class Main {
    static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        for(int i=0;i<=N;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=1;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());
            tree.get(a).add(new Node(b, w));
            tree.get(b).add(new Node(a, w));
        }
        //노드 거리 구하기
        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            bw.write(search(a, b, N) + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    static int search(int start, int end, int n){
        Queue<Node> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        q.add(new Node(start, 0));
        
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.next == end){
                return cur.length;
            }
            //현재 노드 연결된 주변 노드 탐색
            for(Node next : tree.get(cur.next)){
                if(!visited[next.next]){
                    visited[next.next] = true;
                    q.add(new Node(next.next, cur.length + next.length));
                }
            }
        }
        return -1;
    }
    static class Node{
        int next;
        int length;
        public Node(int next, int length){
            this.next = next;
            this.length = length;
        }
    }
}