import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        
        String str = stk.nextToken();
        int n = Integer.parseInt(stk.nextToken());
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(str);
        }
        System.out.println(sb.toString());
    }
}