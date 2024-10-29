class Solution {
    static int[] diffs;
    static int[] times;
    static long limit;
    public int solution(int[] d, int[] t, long l) {
        diffs = d;
        times = t;
        limit = l;
        int answer = Integer.MAX_VALUE;
        
        int start = 1;
        int end = Integer.MAX_VALUE;
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(check(mid)){
                answer = Math.min(answer,mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
    
        return answer;
    }
    public static boolean check(int level){
        long sumTime = 0;
        for(int i = 0; i <diffs.length; i++){
            if(diffs[i] <= level){
            sumTime += (long) times[i];
            }else{
                long failCount = diffs[i] - level;
                if(i == 0){
                    sumTime += (long) times[i] * (failCount + 1);
                }else{
                    long temp = (long) times[i] + (long) times[i-1];
                    sumTime += (long) times[i] + temp * failCount;
                }
            }
            if(limit < sumTime){return false;}
        }
        return limit >= sumTime;
    }
}