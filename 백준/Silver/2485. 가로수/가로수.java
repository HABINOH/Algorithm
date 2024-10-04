import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] streetTree =new int[N];

        for(int i = 0; i < N; i++){
            streetTree[i]=Integer.parseInt(br.readLine());
        }

        br.close();

        int gcd = 0; //가로수 간격의 최대 공약수를 저장하는 변수

        for(int i = 0; i < N-1; i++){
            int distance = streetTree[i+1] - streetTree[i];
            gcd = findGcd(distance, gcd); //가로수 간격의 최대 공약수
        }

		//(streetTree[N-1]-streetTree[0])/gcd은 간격의 수니까
        //가로수의 나무의 개수를 구하려면 간격의 수에서 + 1을 해야한다. 
        bw.write((streetTree[N-1]-streetTree[0])/gcd+1-(streetTree.length) + "");
        bw.flush();
        bw.close();

    }

    static int findGcd(int A, int B){
        while(B != 0){
            int R = A%B;
            A = B;
            B = R;
        }
        return A;
    }
}