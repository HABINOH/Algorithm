import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());

        int[] arr = new int[n];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        int answer = 0;
        for(int i=0;i<n;i++){
            int target = arr[i];

            int start = 0;
            int end = n-1;
            while(start < end){
                int compareNum = arr[start] + arr[end];
                if(target == compareNum){
                    if(start != i && end != i){
                        answer++;
//                        System.out.println(start + " " + end);
                        break;
                    }else if(start == i){
                        start++;
                    }else{
                        end--;
                    }
                }else if(target < compareNum){
                    end--;
                }else{
                    start++;
                }
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
