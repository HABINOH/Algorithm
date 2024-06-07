class Solution {
    
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long st = 0;
        long en = Long.MAX_VALUE/100;
        while(st < en){
            long mid = (st + en) / 2;
            long cnt = cal(mid, times);
            if(n <= cnt){
                en = mid;
            }else{
                st = mid+1;
            }
        }
        return st;
    }
    public long cal(long time, int[] times){
        long sum = 0;
        for(int i=0;i<times.length;i++){
            sum += time / times[i];
        }
        return sum;
    }
}