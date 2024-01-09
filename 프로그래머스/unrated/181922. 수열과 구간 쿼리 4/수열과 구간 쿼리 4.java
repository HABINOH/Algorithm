class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        //queries[0][0] 시작범위
        //queries[0][1] 종료범위
        //queries[0][2] 기준 숫자임 배수 확인
        for(int i=0;i<queries.length;i++){
            for(int j=queries[i][0]; j<=queries[i][1]; j++){
                if(j % queries[i][2] == 0){
                    arr[j] += 1;
                }
            }
        }
        return arr;
    }
}