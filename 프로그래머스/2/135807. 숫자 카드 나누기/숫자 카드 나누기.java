import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int len = arrayA.length;
        ArrayList<Integer> listA = new ArrayList<>();
        Arrays.sort(arrayA);
        for(int i=1;i<=arrayA[arrayA.length-1];i++){ // 나눌 수 있는 수 찾기 (약수)
            boolean isNum = true;
            for(int j=0;j<len;j++){
                if(arrayA[j] % i != 0){isNum = false; break;}
            }
            if(isNum){ //약수임
                listA.add(i);
            }
        }
        ArrayList<Integer> listB = new ArrayList<>();
        Arrays.sort(arrayB);
        for(int i=1;i<=arrayB[arrayA.length-1];i++){ // 나눌 수 있는 수 찾기 (약수)
            boolean isNum = true;
            for(int j=0;j<len;j++){
                if(arrayB[j] % i != 0){isNum = false; break;}
            }
            if(isNum){ //약수임
                listB.add(i);
            }
        }
        for(int num : listA){ // 나눌 수 없는 수 찾기 (정답)
            boolean isNum = true;
            for(int i=0;i<len;i++){
                if(arrayB[i] % num == 0){isNum = false; break;}
            }
            if(isNum){answer = Math.max(answer, num);}
        }
        for(int num : listB){ // 나눌 수 없는 수 찾기 (정답)
            boolean isNum = true;
            for(int i=0;i<len;i++){
                if(arrayA[i] % num == 0){isNum = false; break;}
            }
            if(isNum){answer = Math.max(answer, num);}
        }
        return answer;
    }
}