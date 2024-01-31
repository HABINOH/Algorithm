import java.util.*;
class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k){
        //불가능한 조건 바로 종료
        int goodPassNum = Math.abs(x-r) + Math.abs(y-c);
        int impossibleCheck = goodPassNum % 2;
        if(impossibleCheck != k%2 || k < goodPassNum){
            return "impossible";
        }
        return solve(n,m,x,y,r,c,k);
    }
    public boolean isImpossible(int n, int m, int x, int y, int r, int c, int k) {
        // 범위 밖으로 나가는지 확인
        if (!(1 <= x && x <= n) || !(1 <= r && r <= n) || !(1 <= y && y <= m) || !(1 <= c && c <= m)) {
            return false;
        }
        // 거리 계산
        int dist = Math.abs(x - r) + Math.abs(y - c);
        // k가 거리보다 작거나, k와 거리의 차이가 홀수인 경우 이동 불가능
        if (k < dist || (k - dist) % 2 == 1) {
            return false;
        }
        return true;
    }

    public String solve(int n, int m, int x, int y, int r, int c, int k){
        if(k==0){
            return "";
        }
        //D
        if(isImpossible(n,m,x+1,y,r,c,k-1)){
            return "d" + solution(n,m,x+1,y,r,c,k-1);
        }
        //L
        if(isImpossible(n,m,x,y-1,r,c,k-1)){
            return "l" + solution(n,m,x,y-1,r,c,k-1);
        }
        //R
        if(isImpossible(n,m,x,y+1,r,c,k-1)){
            return "r" + solution(n,m,x,y+1,r,c,k-1);
        }
        //U
        if(isImpossible(n,m,x-1,y,r,c,k-1)){
            return "u" + solution(n,m,x-1,y,r,c,k-1);
        }
        return "";
    }

}