import java.util.*;
class Solution {
    
    class TargetPos{
        int start;
        int end;
        public TargetPos(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int solution(int[][] targets) {
        int answer = 0;
        PriorityQueue<TargetPos> pq = new PriorityQueue<>((c1, c2) -> c1.start - c2.start);
        for(int i=0;i<targets.length;i++){
            int start = targets[i][0];
            int end = targets[i][1];
            pq.add(new TargetPos(start, end));
        }
        
        int lastPos = -1;
        while(!pq.isEmpty()){
            TargetPos curPos = pq.poll();
            int curStart = curPos.start;
            int curEnd = curPos.end;
            
            if(curStart > lastPos){ //새로운 미사일 필요함
                lastPos = curEnd - 1;
                answer++;
            }else if(curEnd < lastPos){ //커버할 수 있는 위치를 줄임
                lastPos = curEnd - 1;
            }
        }
        
        return answer;
    }
}