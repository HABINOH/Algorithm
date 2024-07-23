import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        numbers = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            numbers[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(numbers);

        int start = 1;
        int end = numbers[n-1] - numbers[0];
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(check(mid)){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        bw.write(String.valueOf(end));
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean check(int mid){
        int count = 1;
        int lastNum = numbers[0];
        for(int i=1;i<n;i++){
            if(numbers[i] - lastNum >= mid){
                count++;
                lastNum = numbers[i];
                if(count == k){
                    return true;
                }
            }
        }
        return false;
    }
}