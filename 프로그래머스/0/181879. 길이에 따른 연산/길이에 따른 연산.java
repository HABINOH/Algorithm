class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        
        int len = num_list.length;
        
        if(len >= 11){
            for(int i=0;i<len;i++){
                answer += num_list[i];
            }
        }else{
            answer=1;
            for(int i=0;i<len;i++){
                answer *= num_list[i];
            }
        }
        
        return answer;
    }
}