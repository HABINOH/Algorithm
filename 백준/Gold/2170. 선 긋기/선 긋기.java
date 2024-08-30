import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<Line> lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        lines = new ArrayList<>();
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            lines.add(new Line(start, end));
        }

        Collections.sort(lines);

        int result = 0;
        int beforeStart = lines.get(0).start;
        int beforeEnd = lines.get(0).end;
        for(int i=1;i<n;i++){
            Line curLine = lines.get(i);

            //선이 겹치는 경우
            if(curLine.start <= beforeEnd){
                beforeEnd = Math.max(beforeEnd, curLine.end);
            }else{ //선이 겹치지 않을 경우
                result += beforeEnd - beforeStart;
                //새로운 선 시작점
                beforeStart = curLine.start;
                beforeEnd = curLine.end;
            }
        }
        //마지막 선 길이 더하기
        result += beforeEnd - beforeStart;
        
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    static class Line implements Comparable<Line>{
        int start;
        int end;
        public Line(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Line other){
            return Integer.compare(this.start, other.start);
        }
    }
}
