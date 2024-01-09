class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        //queries[0][0] 시작 범위
        //queries[0][1] 종료 범위
        //queries[0][2] 찾고자 하는 결과 (해당 값보다 커야함)
        
        for(int i=0;i<queries.length;i++){
            int findNum = Integer.MAX_VALUE;
            for(int j=queries[i][0]; j<=queries[i][1]; j++){
                if(queries[i][2] < arr[j]){
                    findNum = Math.min(findNum, arr[j]);
                }
            }
            if(findNum == Integer.MAX_VALUE){answer[i] = -1;}
            else answer[i] = findNum;
        }
        return answer;
    }
}