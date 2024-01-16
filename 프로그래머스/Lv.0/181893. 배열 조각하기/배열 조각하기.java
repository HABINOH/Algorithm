import java.util.*;
class Solution {
    public ArrayList solution(int[] arr, int[] query) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num : arr){list.add(num);}
        for(int i=0;i<query.length;i++){
            int queryNum = query[i];
            if(i%2==0){//짝수 뒷 부분 자르기
                for(int j=queryNum+1;j<list.size();j++){
                    list.remove(j);
                    j--;
                }
            }else{ //홀수 앞 부분 자르기
                for(int j=0; j<queryNum; j++){
                    list.remove(0);
                }
            }
        }
        return list;
    }
}