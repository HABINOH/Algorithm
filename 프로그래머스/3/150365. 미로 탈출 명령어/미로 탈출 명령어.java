import java.util.*;
class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k){
        int goodDis = Math.abs( r-x ) + Math.abs ( c-y );
        int checkDis = goodDis % 2;
        if(((goodDis % 2) != k % 2) || k<goodDis){return "impossible";}
        
        return dfs(n,m,x,y,r,c,k);
    }
    
    public String dfs(int n, int m, int x, int y, int r, int c, int k){
        if(k==0){return "";}
        
        //d
        if(!isImpossible(n,m,x+1,y,r,c,k-1))
            return "d" + dfs(n,m,x+1,y,r,c,k-1);
        //l
        if(!isImpossible(n,m,x,y-1,r,c,k-1))
            return "l" + dfs(n,m,x,y-1,r,c,k-1);
        //r
        if(!isImpossible(n,m,x,y+1,r,c,k-1))
            return "r" + dfs(n,m,x,y+1,r,c,k-1);
        //u
        if(!isImpossible(n,m,x-1,y,r,c,k-1))
            return "u" + dfs(n,m,x-1,y,r,c,k-1);

        return "";
    }
    
    public boolean isImpossible(int n, int m, int x, int y, int r, int c, int k){
        //범위 체크
        if(x<1 || y<1 || x>n || y>m)
            return true;
        
        int goodDis = Math.abs( r-x ) + Math.abs ( c-y );
        int checkDis = goodDis % 2;
        if(((goodDis % 2) != k % 2) || k<goodDis){return true;}
        
        return false;
    }

}