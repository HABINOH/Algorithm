import java.util.*;
class Solution {
    public ArrayList solution(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=1;i<=n;i++){
            if(i%k == 0){
                list.add(i);
            }
        }
        
        return list;
    }
}