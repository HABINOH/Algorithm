import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int n = Integer.parseInt(br.readLine());

            if (n == -1) {
                break;
            }

            int[] array = new int[n];

            int sum = 0;

            for (int i = 1; i <= n; i++) {
                if (n % i == 0 && i != n) {
                    array[i] = i;
                    sum += i;
                }
                //차피 아니면 0이 들어감(약수는 0이 나올 수 X)
            }

            //완전수가 아닐 경우
            if (sum != n) { //다른 것과 구분하려면 앞으로 빼는 것이 나음!
                sb.append(n+ " is NOT perfect. \n");
                continue; //완전수가 아니기때문에 밑의 코드는 수행 X
            }

            sb.append(n + " = 1"); //1의 약수는 차피 무조건 추가  이기 때문에

            for(int i = 1; i <= n; i++){ //약수의 최대 몇개 인지 알고 있기 때문에 index만큼 반복문
                if(array[i-1] != 0 && array[i-1] != 1){ //숫자 출력 부분 1출력은 생략한다.
                    sb.append(" + " + array[i-1]);
                }

            }
            sb.append("\n");

        }
        br.close();
        System.out.println(sb);
    }

}