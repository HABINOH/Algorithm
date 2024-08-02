import java.util.*;
import java.io.*;
public class Main {
    static long[] result = new long[2];
    static long max = Long.MAX_VALUE-1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(stk.nextToken());
        }
        Arrays.sort(arr);

        int left = 0;
        int right = n-1;
        while(left < right){
            long sum = arr[left] + arr[right];

            if(Math.abs(sum) < max){
                result[0] = arr[left];
                result[1] = arr[right];
                max = Math.abs(sum);
            }

            if(sum < 0){
                left++;
            }else{
                right--;
            }
        }
        Arrays.sort(result);

        bw.write(result[0] + " " + result[1]);
        bw.flush();
        bw.close();
        br.close();
    }

}
