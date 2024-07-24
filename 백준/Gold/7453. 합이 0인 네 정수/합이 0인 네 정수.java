import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        int[][] numbers = new int[n][n];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            numbers[i][0] = Integer.parseInt(stk.nextToken());
            numbers[i][1] = Integer.parseInt(stk.nextToken());
            numbers[i][2] = Integer.parseInt(stk.nextToken());
            numbers[i][3] = Integer.parseInt(stk.nextToken());
        }

        int[] AB = new int[n*n];
        int[] CD = new int[n*n];
        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++) {
                AB[idx] = numbers[i][0] + numbers[j][1];
                CD[idx++] = numbers[i][2] + numbers[j][3];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int left = 0;
        int right = n*n-1;
        long result = 0;
        while((left < n*n) && right >= 0){
            if(AB[left] + CD[right] < 0){
                left++;
            }else if(AB[left] + CD[right] > 0){
                right--;
            }else{
                long leftCnt = 1;
                long rightCnt= 1;
                while((left+1 < n*n) && (AB[left] == AB[left+1])){
                    leftCnt++;
                    left++;
                }
                while((right > 0) && (CD[right] == CD[right-1])){
                    rightCnt++;
                    right--;
                }
                result += leftCnt * rightCnt;
                left++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}