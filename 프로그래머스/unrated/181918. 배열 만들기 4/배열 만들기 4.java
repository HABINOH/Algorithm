import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while(i<arr.length){
            if(list.size()==0){list.add(arr[i]); i+=1;}
            if(list.size()!=0){
                if(list.get(list.size()-1) < arr[i]){
                    list.add(arr[i]);
                    i+=1;
                }else{
                    list.remove(list.size()-1);
                }
            }
        }
        int[] stk = new int[list.size()];
        for(int index=0;index<list.size();index++){
            stk[index] = list.get(index);
        }
        return stk;
    }
}