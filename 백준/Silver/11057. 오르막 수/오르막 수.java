import java.util.*;
import java.io.*;

public class Main {
    static long[] dp;
    static long[][] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        numbers = new long[n+1][10];

        for(int i=0;i<10;i++){
            numbers[1][i] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=0; j<10; j++){
                for(int k=0; k<=j; k++){
                    numbers[i][j] += numbers[i-1][k];
                    numbers[i][j] %= 10_007;
                }
            }
        }
        long result = 0;
        for(int i=0;i<10;i++){
            result += numbers[n][i];
        }
        bw.write(String.valueOf(result % 10_007));
        bw.flush();
        bw.close();
        br.close();
    }
}
