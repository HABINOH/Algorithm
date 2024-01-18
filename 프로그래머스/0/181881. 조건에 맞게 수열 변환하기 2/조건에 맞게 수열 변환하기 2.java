import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = Integer.MAX_VALUE;
        int cnt = 1;
        while(cnt!=0){
            int[] temp = Arrays.copyOf(arr, arr.length);
            boolean check = true;
            for(int i=0;i<arr.length;i++){
                if(arr[i] >= 50 && arr[i]%2==0){
                    arr[i] /= 2;
                }else if(arr[i] < 50 && arr[i]%2==1){
                    arr[i] *= 2;
                    arr[i] += 1;
                }
            }
            for(int j=0;j<temp.length;j++){
                if(temp[j] != arr[j]){
                    check = false;
                }
            }
            if(check){answer = cnt-1; break;}
            cnt++;
        }
        return answer;
    }
}