import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;
        
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            hs.add(nums[i]);
        }
        
        if(hs.size() < answer){
            answer = hs.size();
        }
        
        return answer;
    }
}