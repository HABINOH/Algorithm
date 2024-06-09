import java.util.*;
class Solution {
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    public int solution(int[][] maps) {
        int answer = -1;        
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Pos> qu = new LinkedList<>();
        
        qu.add(new Pos(0,0,1));
        
        while(!qu.isEmpty()){
            Pos pos = qu.poll();
            int x = pos.x;
            int y = pos.y;
            int dist = pos.dist;
            
            if(x == maps.length-1 && y == maps[0].length-1){
                answer = dist;
            }
            
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(isNext(nx,ny,maps.length,maps[0].length) && !visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    qu.add(new Pos(nx, ny, dist+1));
                }
            }
        }
        return answer;
    }
    
    public boolean isNext(int x, int y, int n, int m){
        return !(x<0 || y<0 || x>=n || y>=m);
    }
    
    
    class Pos{
        int x;
        int y;
        int dist;
        
        public Pos(int x, int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}