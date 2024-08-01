import java.util.*;
import java.io.*;
public class Main {
    static long[] result = new long[3];
    static long max = Long.MAX_VALUE-1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(stk.nextToken());
        }
        Arrays.sort(arr);

        for(int i=0;i<n-2;i++) {
            twoPointer(arr, i);
        }
        Arrays.sort(result);

        bw.write(result[0] + " " + result[1] + " " + result[2]);
        bw.flush();
        bw.close();
        br.close();
    }
    static void twoPointer(long[] arr, int idx){
        int left = idx+1;
        int right = arr.length-1;

        while(left < right){
            long sum = arr[left] + arr[right] + arr[idx];

            if(Math.abs(sum) < max){
                result[0] = arr[left];
                result[1] = arr[right];
                result[2] = arr[idx];
                max = Math.abs(sum);
            }

            if(sum < 0){
                left++;
            }else{
                right--;
            }
        }
    }
}
