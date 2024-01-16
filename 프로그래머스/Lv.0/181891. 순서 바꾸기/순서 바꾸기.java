import java.util.*;
class Solution {
    public ArrayList solution(int[] num_list, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=n; i<num_list.length; i++){
            list.add(num_list[i]);
        }
        for(int i=0;i<n;i++){
            list.add(num_list[i]);
        }
        return list;
    }
}