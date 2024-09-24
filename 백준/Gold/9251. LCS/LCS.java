import java.util.*;
import java.io.*;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars1 = br.readLine().toCharArray();
        char[] chars2 = br.readLine().toCharArray();

        int len1 = chars1.length;
        int len2 = chars2.length;
        dp = new int[len1+1][len2+1];
        //문자열을 2차원 배열 모양으로 그려놓고 생각해야함 (부분 수열까지 고려)
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(chars1[i-1] == chars2[j-1]){ //왼쪽 대각선 길이 +1
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{ //위쪽, 왼쪽 중 길이 큰 값으로 갱신
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        bw.write(String.valueOf(dp[len1][len2]));
        bw.flush();
        bw.close();
        br.close();
    }
}
