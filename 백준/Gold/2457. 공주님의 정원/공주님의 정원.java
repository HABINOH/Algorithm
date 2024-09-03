import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        ArrayList<Flower> flowers = new ArrayList<>();
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int monthOne = Integer.parseInt(stk.nextToken());
            int dayOne = Integer.parseInt(stk.nextToken());

            int monthTwo = Integer.parseInt(stk.nextToken());
            int dayTwo = Integer.parseInt(stk.nextToken());

            int start = monthOne * 100 + dayOne;
            int end = monthTwo * 100 + dayTwo;

            flowers.add(new Flower(start, end));
        }
        Collections.sort(flowers);

        int startDay = 301;
        int endDay = 0;
        int idx = 0;
        int result = 0;
        while(startDay < 1201){
            boolean check = false;
            for(int i=idx;i<flowers.size();i++){
                Flower curFlower = flowers.get(i);
                if(curFlower.start > startDay){break;}
                if(curFlower.end > endDay){
                    endDay = curFlower.end;
                    idx = i+1;
                    check = true;
                }
            }
            if(check){
                result++;
                startDay = endDay;
            }else{
                break;
            }
        }
        if(endDay < 1201){
            result = 0;
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    static class Flower implements Comparable<Flower>{
        int start;
        int end;
        public Flower(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Flower other){
            int compareStart = Integer.compare(this.start, other.start);
            if(compareStart != 0){
                return compareStart;
            }
            return Integer.compare(other.end, this.end);
        }
    }
}
