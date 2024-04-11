import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};            //5
        int[] two = {2,1,2,3,2,4,2,5};      //8
        int[] three = {3,3,1,1,2,2,4,4,5,5};//10
        
        int[] cnt = new int[3];
        for(int i=0;i<answers.length;i++){
            if(answers[i] == one[i%5]) cnt[0]++;
            if(answers[i] == two[i%8]) cnt[1]++;
            if(answers[i] == three[i%10]) cnt[2]++;
        }
        int max = Math.max(cnt[0],cnt[1]);
        max = Math.max(max, cnt[2]);
        
        Vector<Integer> vc = new Vector<>();
        if(max == cnt[0]) vc.add(1);
        if(max == cnt[1]) vc.add(2);
        if(max == cnt[2]) vc.add(3);
        
        int[] result = new int[vc.size()];
        for(int i=0;i<vc.size();i++){
            result[i] = vc.get(i);
        }
        
        return result;
    }
}