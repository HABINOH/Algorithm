import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        for(int i=0;i<n;i++){
            String str = br.readLine();
            bw.write(String.valueOf(checkPalindrome(str)));
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static int checkPalindrome(String str){
        if(isPalindrome(str, 0, str.length()-1)){
            return 0;
        }else if(isPseudoPalindrome(str, 0, str.length()-1)){
            return 1;
        }else {
            return 2;
        }
    }
    static boolean isPalindrome(String str, int start, int end){
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    static boolean isPseudoPalindrome(String str, int start, int end){
        while (start < end) {
            if(str.charAt(start) != str.charAt(end)){
                return isPalindrome(str, start+1, end) || isPalindrome(str, start, end-1);
            }
            start++;
            end--;
        }
        return true;
    }
}
