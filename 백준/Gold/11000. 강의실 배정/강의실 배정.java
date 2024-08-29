import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static ArrayList<ClassTime> classTimes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        classTimes = new ArrayList<>();
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            classTimes.add(new ClassTime(start, end));
        }

        Collections.sort(classTimes);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(classTimes.get(0).endTime);

        for(int i=1; i<n; i++){
            if(!pq.isEmpty() && pq.peek() <= classTimes.get(i).startTime){
                pq.poll();
            }
            pq.add(classTimes.get(i).endTime);
        }

        bw.write(String.valueOf(pq.size()));
        bw.flush();
        bw.close();
        br.close();
    }
    static class ClassTime implements Comparable<ClassTime>{
        int startTime;
        int endTime;
        public ClassTime(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(ClassTime other){
            int endCompare = Integer.compare(this.startTime, other.startTime);
            if(endCompare != 0){
                return endCompare;
            }else{
                return Integer.compare(this.endTime, other.endTime);
            }
        }
    }
}
