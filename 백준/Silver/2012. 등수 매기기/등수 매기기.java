import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int B = 1;		// 실제 등수
		long sum = 0;	// 불만도 합 최솟값
		int[] arr = new int[N];
		
		for(int i=0; i<arr.length; i++)
			arr[i] = scan.nextInt();
		
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length; i++) {
			sum += Math.abs(arr[i] - (i+1));			
		}
		
		System.out.println(sum);
		scan.close();
	}

}