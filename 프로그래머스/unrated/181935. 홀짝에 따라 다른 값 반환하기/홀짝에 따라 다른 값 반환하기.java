class Solution {
    public int solution(int n) {
        int answer = 0;
        
        if(n % 2 == 1){
            for(int i=n; i>0; i--){
                if(i%2 == 1){
                    answer += i;
                }
            }
        }else{
            for(int i=n; i>0; i--){
                if(i%2 == 0){
                    answer += i*i;
                }
            }
        }
        
        return answer;
    }
}