import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(br.readLine());

        int[] liquid = new int[n];
        for(int i=0;i<n;i++){
            liquid[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(liquid);

        ArrayList<Integer> answer = new ArrayList<>();
        int similarZero = Integer.MAX_VALUE;
        int saveLeft=0, saveRight=0;
        int start = 0;
        int end = n-1;
        while(start != end){
            int leftLiquid = liquid[start];
            int rightLiquid = liquid[end];
            int mixLiquid = leftLiquid + rightLiquid;

            if(Math.abs(mixLiquid) < similarZero){
                similarZero = Math.abs(mixLiquid);
                saveLeft = start;
                saveRight = end;
            }

            if(mixLiquid == 0){
                answer.add(leftLiquid);
                answer.add(rightLiquid);
                break;
            }
            else if(mixLiquid < 0){
                start++;
            }else {
                end--;
            }
        }
        if(answer.isEmpty()){
            answer.add(liquid[saveLeft]);
            answer.add(liquid[saveRight]);
        }
        Collections.sort(answer);
        bw.write(answer.get(0) + " " + answer.get(1));
        bw.flush();
        bw.close();
        br.close();
    }
}
