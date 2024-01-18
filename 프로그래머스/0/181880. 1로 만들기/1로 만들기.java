class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        while(true){
            boolean check = true;
            for(int i=0;i<num_list.length;i++){
                if(num_list[i] != 1){
                    if(num_list[i] %2 == 1){
                        num_list[i] -=1;
                    }   
                    num_list[i] /= 2;
                    check = false;
                    answer++;
                }
            }
            if(check){break;}
        }
        
        return answer;
    }
}