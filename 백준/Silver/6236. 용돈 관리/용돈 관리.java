import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] pinMoney;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        int totalMoney = 0;
        int maxPinMoney = 0;
        pinMoney = new int[n];
        for(int i=0;i<n;i++){
            stk = new StringTokenizer(br.readLine());
            pinMoney[i] = Integer.parseInt(stk.nextToken());
            totalMoney += pinMoney[i];
            maxPinMoney = Math.max(maxPinMoney, pinMoney[i]);
        }

        int result = totalMoney;
        int start = maxPinMoney;
        int end = totalMoney;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(check(mid)){
                result = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    static boolean check(int mid){
        int count = 1;
        int money = mid;
        for(int i=0;i<n;i++){
            if(pinMoney[i] > mid){return false;}
            if(money >= pinMoney[i]){
                money -= pinMoney[i];
            }else{
                count++;
                money = mid - pinMoney[i];
            }
        }
        return count <= m;
    }
}