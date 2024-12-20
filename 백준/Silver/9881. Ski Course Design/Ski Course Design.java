import java.util.*;
import java.io.*;

public class Main {
    static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static ArrayList<Integer> elevation = new ArrayList<>();	//언덕 높이 저장 리스트
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        //1. 입력되는 언덕들의 높이를 받아서 높이의 최대값과 최소값을 구합니다.
        for(int i=0;i<N;i++){
            int temp = Integer.parseInt(br.readLine());
            max = Math.max(max, temp);
            min = Math.min(min, temp);
            elevation.add(temp);
        }
        int answer = Integer.MAX_VALUE;
        //2. 최대값과 최소값을 기준으로 나올 수 있는 언덕의 차를 모두 구해서 최소 지불 금액을 구합니다.
        for(int i=min;i<max-17;i++)
            answer = Math.min(answer, cal(i, i+17));
        if(answer == Integer.MAX_VALUE)	//입력된 언덕으로도 세금을 피할 수 있을 때
            bw.write("0");
        else		//세금 피하지 못할 때 지불 최소 비용 BufferedWriter 저장
            bw.write(answer + "");
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //해당 최대, 최소로 언덕을 바꿀 때 지불 비용 구하는 함수
    static int cal(int min, int max){
        int result = 0;
        for(int i=0;i<N;i++){
            int temp = 0;
            if(elevation.get(i) > max)
                temp = (int) Math.pow(elevation.get(i) - max ,2);
            else if(elevation.get(i) < min)
                temp = (int) Math.pow(min - elevation.get(i), 2);
            result += temp;
        }
        return result;
    }
}