import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(in.readLine());
		
		ArrayDeque<int[]> q = new ArrayDeque<>();

		StringTokenizer st= new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			int pizza = Integer.parseInt(st.nextToken());
			q.offer(new int[] {i, pizza});
		}
		
		int time=0;
		int[] save =new int[N]; 
		while(!q.isEmpty()) {
			time++;
			int[] tmp = q.poll();
			int pizza = tmp[1] - 1;	
			if(pizza == 0) {
				save[tmp[0]] = time;
			}else {
				q.offer(new int[] {tmp[0],pizza});
			}
		}	
		for(int i=0;i<N;i++) {
			System.out.print(save[i]+" ");
		}
	}
}