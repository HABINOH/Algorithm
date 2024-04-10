import java.util.*;
class Solution {
    static int[] arr = new int[11];
    static boolean[] visited = new boolean[11];
    static int[] copyInfo = new int[11];
    static int[] temp = new int[11];
    static int maxDiff = 0;
    static int[] answer = new int[11];
    public int[] solution(int n, int[] info) {
        copyInfo = info;
        go(0, n);
        if(maxDiff == 0){
            return new int[]{-1};
        }
        return answer;
    }
    public void go(int depth, int total){
        if(depth == 10){
            int ryan = 0;
            int apeach = 0;
            int cnt = 0;
            for(int idx = 0; idx < 10; idx++){
                if(arr[idx] != 0){ //라이언이 이김
                    ryan += 10 - idx; //라이언 점수
                    temp[idx] = copyInfo[idx] + 1; //해당하는 자리 화살 개수 저장
                    cnt += temp[idx]; //total 화살 개수
                }else{ //어피치가 이김
                    temp[idx] = 0; //지는 경우 화살 0개 쏨
                    if(copyInfo[idx] > 0){
                        apeach += 10 - idx; //어피치 점수
                    }
                }
            }
            if(cnt > total) return; //라이언이 어피치보다 화살을 더 쓴 경우 무시
            
            temp[10] = total - cnt; //남은 화살을 0점에 기록
            if((ryan - apeach) == maxDiff){ //점수 차이가 같은 경우
                for(int j = 10; j>=0; j--){ //낮은 점수를 더 많이 맞힌 경우 찾기
                    if(temp[j] > answer[j]){
                        maxDiff = ryan - apeach;
                        answer = Arrays.copyOf(temp, temp.length);
                        break;
                    }else if(temp[j] < answer[j]){
                        break;
                    }
                }
            }
            else if(ryan - apeach > maxDiff){ //기존보다 큰 점수차이로 이긴 경우
                maxDiff = ryan - apeach;
                answer = Arrays.copyOf(temp, temp.length);
            }
            return;
        }
        arr[depth] = 0;
        go(depth+1, total);
        arr[depth] = 1;
        go(depth+1, total);
    }
}
//완전탐색(부분 집합)
//이기고 지는 경우에 대한 모든 경우 부분집합으로 추출
//화살 쏘기
//차이가 가장 큰 값이면 answer 배열 교체
/*
*/
