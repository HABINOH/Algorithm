import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int i = 0;
        int[] numbers = new int[n];
        while (stk.hasMoreTokens()){
            numbers[i++] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(numbers);

        int result = 0;
        for(i=0;i<n;i++){
            int target = numbers[i];
            int start = 0;
            int end = n-1;

            while(start < end){
                int sum = numbers[start] + numbers[end];
                if(sum == target){
                    if(start != i && end != i){
                        result++;
                        break;
                    }else if(start == i){
                        start++;
                    }else{
                        end--;
                    }
                }else if(sum < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}