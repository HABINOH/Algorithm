class Solution {
    public int updateLen(int len, int[] go, int cap){
        while(cap > 0 && len!=0){
            if(go[len-1] > cap){
                go[len-1] -= cap;
                cap=0;
            }else{
                cap -= go[len-1];
                len--;
            }
        }
        return len;
    }
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int devLen = deliveries.length;
        int picLen = pickups.length;
        while(devLen > 0 || picLen > 0){
            while(devLen > 0 && deliveries[devLen - 1] == 0){
                devLen--;
            } while(picLen > 0 && pickups[picLen - 1] == 0){
                picLen--;
            }
            answer += Math.max(devLen, picLen) * 2;
            devLen = updateLen(devLen, deliveries, cap);
            picLen = updateLen(picLen, pickups, cap);
        }
        return answer;
    }
}