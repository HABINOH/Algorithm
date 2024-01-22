import java.util.*;
class Solution {
    public ArrayList solution(int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i];j++){
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}