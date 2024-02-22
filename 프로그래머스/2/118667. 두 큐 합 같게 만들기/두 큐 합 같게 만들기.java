import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long sum1 = 0, sum2 = 0;
        for(int i=0;i<queue1.length;i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        int len = q1.size();
        if(sum1 == sum2){return answer;}
        boolean notResult = false;
        while(true){
            int num = 0;
            if(sum1 > sum2){ //왼쪽 큐가 클 경우 오른쪽 큐로 옮긴다.
                num = q1.poll();
                q2.add(num);
                sum1 -= num;
                sum2 += num;
            }else if(sum1 < sum2){ //오른쪽 큐가 클 경우 왼쪽 큐로 옮긴다.
                num = q2.poll();
                q1.add(num);
                sum2 -= num;
                sum1 += num;
            }else{ //양쪽 합이 같을 경우 작업 종료
                break;
            }
            if(answer > len*4){notResult = true; break;}
            answer++;
        }
        if(notResult){answer = -1;}
        return answer;
    }
}