import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		if(n==0){
		    System.out.println("0");
		    System.out.println("0");
		    System.exit(0);
		}
		
		int tmp = Math.abs(n);
		long[] dp = new long[1000001];
		dp[0] = 0;
		dp[1] = 1;
		for(int i = 2; i <= tmp; i++)
	        dp[i] = (dp[i-1]+dp[i-2])%1000000000;
		
		System.out.println((n>0)? "1": (tmp%2==0)? "-1":"1");
		System.out.println(dp[tmp]);
	}
}