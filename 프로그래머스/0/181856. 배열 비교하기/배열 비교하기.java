class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        
        int arrLen1 = arr1.length;
        int arrLen2 = arr2.length;
        
        if(arrLen1 != arrLen2){
            if(arrLen1 > arrLen2){answer = 1;}
            else{answer = -1;}
        }else{
            int arrSum1 = 0;
            for(int i=0;i<arr1.length;i++){
                arrSum1 += arr1[i];
            }
            int arrSum2 = 0;
            for(int i=0;i<arr2.length;i++){
                arrSum2 += arr2[i];
            }
            if(arrSum1 != arrSum2){
                if(arrSum1 > arrSum2){answer = 1;}
                else if(arrSum1 < arrSum2){answer = -1;}
            }
        }
        return answer;
    }
}