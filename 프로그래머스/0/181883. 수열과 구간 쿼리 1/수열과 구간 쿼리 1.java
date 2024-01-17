class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for(int i=0;i<queries.length;i++){
            for(int idx=queries[i][0]; idx<=queries[i][1]; idx++){
                arr[idx]+=1;
            }
        }
        return arr;
    }
}