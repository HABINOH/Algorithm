import java.util.*;
class Solution {
    public ArrayList solution(int[] num_list, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=n-1; i<num_list.length;i++){
            list.add(num_list[i]);
        }
        
        return list;
    }
}