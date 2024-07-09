import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        if(k == enemy.length){
            return k;
        }
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        for(int i=0;i<enemy.length;i++){
            if(n - enemy[i] < 0 && k==0){break;}
            pq.add(enemy[i]);
            if(n - enemy[i] < 0){
                n += pq.poll();
                k--;
            }
            n -= enemy[i];
            answer++;
        }
        return answer;
    }
}