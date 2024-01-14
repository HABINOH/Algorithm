import java.util.*;
class Solution {
    public String solution(String my_string, int[] indices) {
        Set<Integer> idxSet = new HashSet<>();
        for(int idx : indices){
            idxSet.add(idx);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<my_string.length();i++){
            if(!idxSet.contains(i)){
                sb.append(my_string.charAt(i));
            }
        }
        return sb.toString();
    }
}