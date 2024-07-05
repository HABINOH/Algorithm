import java.io.*;
import java.util.*;
public class Main {
    static long n;
    static long m;
    static long[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Long.parseLong(stk.nextToken());
        m = Long.parseLong(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        tree = new long[(int) n];
        int idx = 0;
        while (stk.hasMoreTokens()) {
            tree[idx++] = Long.parseLong(stk.nextToken());
        }
        Arrays.sort(tree); //나무 높이 정렬
        long l = 0; //초기 최소 나무 높이
        long h = Long.MAX_VALUE; //초기 최대 나무 높이

        while(l+1 < h){
            long mid = (l + h) / 2; //현재 자르는 나무 높이
            if(check(mid)){
                l = mid;
            }else{
                h = mid;
            }
        }
        bw.write(String.valueOf(l));
        bw.flush();
    }
    static boolean check(long mid){
        long sum = 0;
        for(int i=0;i<n;i++){
            if(tree[i] >= mid) {
                sum += tree[i] - mid;
            }
        }
        //가져 가려고 하는 나무 길이가
        //가져갈 수 있는 나무 길이(m) 보다 크면
        //더 높은 높이로 자를 수 있는지 확인
        return sum >= m;
    }
}