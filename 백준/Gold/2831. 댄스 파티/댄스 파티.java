import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        ArrayList<Integer> plusMan = new ArrayList<>();
        ArrayList<Integer> minusMan = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(stk.nextToken());
            if(num > 0){
                plusMan.add(num);
            }else{
                minusMan.add(num * -1);
            }
        }

        ArrayList<Integer> plusWoman = new ArrayList<>();
        ArrayList<Integer> minusWoman = new ArrayList<>();
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int num = Integer.parseInt(stk.nextToken());
            if(num > 0){
                plusWoman.add(num);
            }else{
                minusWoman.add(num * -1);
            }
        }

        Collections.sort(plusMan);
        Collections.sort(minusMan);
        Collections.sort(plusWoman);
        Collections.sort(minusWoman);

        int answer = 0;

        int mp = 0;
        int wp = 0;
        while(mp < minusMan.size() && wp < plusWoman.size()){
            int man = minusMan.get(mp);
            int woman = plusWoman.get(wp);

            if(man <= woman){mp++;}
            else{
                answer++;
                mp++; wp++;
            }
        }

        mp = 0; wp = 0;
        while(mp < plusMan.size() && wp < minusWoman.size()){
            int man = plusMan.get(mp);
            int woman = minusWoman.get(wp);

            if(man >= woman){wp++;}
            else{
                answer++;
                mp++; wp++;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
