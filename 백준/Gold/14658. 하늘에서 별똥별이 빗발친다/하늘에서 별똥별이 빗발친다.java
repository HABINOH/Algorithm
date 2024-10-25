import java.util.*;
import java.io.*;

public class Main {
    static int n,m,l,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        l = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        int[][] stars = new int[k][2];
        for(int i=0;i<k;i++){
            stk = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(stk.nextToken());
            stars[i][1] = Integer.parseInt(stk.nextToken());
        }

        int answer = 0;
        for(int i=0;i<k;i++){
            for(int j=0;j<k;j++){
                int x1 = stars[i][0];  // 트램펄린의 왼쪽 아래 x 좌표
                int y1 = stars[j][1];  // 트램펄린의 왼쪽 아래 y 좌표
                int x2 = x1 + l;       // 트램펄린의 오른쪽 위 x 좌표
                int y2 = y1 + l;       // 트램펄린의 오른쪽 위 y 좌표

                // 트램펄린 내에 포함되는 별똥별의 개수 count
                int count = 0;
                for(int z=0;z<k;z++){
                    int x = stars[z][0];
                    int y = stars[z][1];

                    if(x >= x1 && x <= x2 && y >= y1 && y <= y2){
                        count++;
                    }
                }
                answer = Math.max(answer, count);
            }
        }
        // 전체 별똥별 수에서 트램펄린이 커버하는 별똥별 수를 뺀 값
        bw.write(String.valueOf(k - answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
