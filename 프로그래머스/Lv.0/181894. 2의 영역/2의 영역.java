import java.util.*;
class Solution {
    public ArrayList solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int start = -1;
        int end = -1;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == 2 && count == 0){
                start = i;
                count++;
            }else if(count != 0 && arr[i] == 2){
                end = i;
            }
        }
        if(start == -1 && end == -1){list.add(-1); return list;}
        else if(start == -1 || end == -1){list.add(2); return list;}
        for(int i=start; i<=end; i++){
            list.add(arr[i]);
        }
        return list;
    }
}