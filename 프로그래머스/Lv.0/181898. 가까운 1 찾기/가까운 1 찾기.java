class Solution {
    public int solution(int[] arr, int idx) {
        int answer = Integer.MAX_VALUE;
        
        for(int i=idx;i<arr.length;i++){
            if(arr[i] != 0){
                answer = Math.min(i, answer);
            }
        }
        if(answer == Integer.MAX_VALUE){
            answer = -1;
        }
        
        return answer;
    }
}