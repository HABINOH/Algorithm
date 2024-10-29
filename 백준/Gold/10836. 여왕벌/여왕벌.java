import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(stk.nextToken());
        int day = Integer.parseInt(stk.nextToken());

        int[] board = new int[m*2-1];
        Arrays.fill(board, 1);
        while(day --> 0){
            stk = new StringTokenizer(br.readLine());
            int zero = Integer.parseInt(stk.nextToken());
            int one = Integer.parseInt(stk.nextToken());
            int two = Integer.parseInt(stk.nextToken());

            for(int i=zero; i<zero+one; i++){
                board[i] += 1;
            }

            for(int i=zero+one; i<m*2-1; i++){
                board[i] += 2;
            }
        }
//        for(int i=0;i<2*m-1;i++){
//            System.out.print(board[i] + " ");
//        }

        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(j==0) {
                    bw.write(board[m - i - 1] + " ");
                }else{
                    bw.write(board[m + j - 1] + " ");
                }
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
