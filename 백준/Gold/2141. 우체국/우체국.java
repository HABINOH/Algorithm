import java.io.*;
import java.util.*;

public class Main {
    static class Village implements Comparable<Village>{
        int idx;
        int person;
        public Village(int idx, int person){
            this.idx = idx;
            this.person = person;
        }
        public int compareTo(Village village){
            return this.idx - village.idx;
        }
    }
    static ArrayList<Village> villages = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        long totalPerson = 0;
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(stk.nextToken());
            int person = Integer.parseInt(stk.nextToken());
            villages.add(new Village(idx, person));
            totalPerson += person;
        }

        Collections.sort(villages);

        long mid = 0;
        for(int i=0;i<n;i++){
            mid += villages.get(i).person;
            if(mid >= (totalPerson+1) / 2){
                bw.write(String.valueOf(villages.get(i).idx));
                break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
