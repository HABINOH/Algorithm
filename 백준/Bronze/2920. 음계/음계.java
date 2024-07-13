import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] ascending = {1,2,3,4,5,6,7,8};
		int[] descending = {8,7,6,5,4,3,2,1};
		int[] num = new int[8];
		for(int i = 0; i < num.length; i++) {
			num[i] = scan.nextInt();
		}
		
		if(Arrays.equals(num, ascending)) {
			System.out.println("ascending");
		}
		else if(Arrays.equals(num, descending)){
			System.out.println("descending");
		}
		else {
			System.out.println("mixed");
		}
		scan.close();
	}
}