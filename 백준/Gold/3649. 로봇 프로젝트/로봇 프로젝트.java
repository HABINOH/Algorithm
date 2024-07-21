import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = null;

        while((str = br.readLine()) != null){
            int w = Integer.parseInt(str) * 10000000;
            int n = Integer.parseInt(br.readLine());
            boolean result = false;

            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(nums);

            int left = 0;
            int right = n-1;

            while(left < right){
                int sum = nums[left] + nums[right];
                if(sum == w){
                    result = true;
                    break;
                }else if(sum > w){
                    right--;
                }else{
                    left++;
                }
            }
            if(result){
                bw.write("yes " + nums[left] + " " + nums[right] + "\n");
            }else{
                bw.write("danger\n");
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }
}