import java.io.*;
import java.util.*;

public class Main {
    static long[][] rooms;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        long n = Long.parseLong(stk.nextToken());
        long atk = Long.parseLong(stk.nextToken());

        rooms = new long[(int)n][3];
        for(int i=0; i<(int)n; i++){
            stk = new StringTokenizer(br.readLine());
            rooms[i][0] = Long.parseLong(stk.nextToken());
            rooms[i][1] = Long.parseLong(stk.nextToken());
            rooms[i][2] = Long.parseLong(stk.nextToken());
        }

        bw.write(String.valueOf(solution(atk)));
        bw.flush();
        bw.close();
        br.close();
    }
    static long solution(long atk){
        long start = 1;
        long end = Long.MAX_VALUE;

        while(start <= end){
            long mid = start + (end - start) / 2;
            if(check(mid, atk)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return start;
    }
    static boolean check(long mid, long atk){
        long hp = mid;
        for(long[] room : rooms){
            long t = room[0]; // 선택(1:몬스터, 2:휴식)
            long a = room[1]; // 1:몬스터 공격력, 2:공격력 증가 +
            long h = room[2]; // 1:몬스터 생명력, 2:체력 회복 +

            if(t == 1L){ // (몬스터 생명력 / 용사 공격력) * 몬스터 공격력
                if(h % atk == 0){ //몬스터 죽이기 위한 공격력, 체력 반영
                    hp -= a * (h / atk - 1);
                }else{
                    hp -= a * (h / atk);
                }
                if(hp <= 0){return true;}
            }else{
                atk += a;
                hp += h;
                if(hp > mid){hp = mid;}
            }
        }
        return false;
    }
}