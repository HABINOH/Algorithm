import java.util.*;
import java.io.*;

public class Main {
    static class Water implements Comparable<Water>{
        int st;
        int en;
        public Water(int st, int en){
            this.st = st;
            this.en = en;
        }
        @Override
        public int compareTo(Water water) {
            return st - water.st;
        }
    }
    static PriorityQueue<Water> pq;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int l = Integer.parseInt(stk.nextToken());

        pq = new PriorityQueue<>((c1, c2) -> c1.st - c2.st);
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int st = Integer.parseInt(stk.nextToken());
            int en = Integer.parseInt(stk.nextToken());
            pq.add(new Water(st, en));
        }

        int start = 0;
        while(!pq.isEmpty()){
            Water cur = pq.poll();
            //현재 널빤지 길이로 덮인 곳보다 그 다음 가야할 끝 지점 길이가 길면 스킵
            if(cur.en < start){
                continue;
            }
            //시작점
            start = Math.max(cur.st, start);

            //웅덩이 길이
            int width = cur.en - start;

            //널빤지 필요 개수
            int count = 0;
            if(width % l != 0){
                count += (width / l) + 1;
            }else{
                count += width / l;
            }

            //시작점 갱신
            start += count * l;

            //널빤지 개수 더하기
            answer += count;
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
