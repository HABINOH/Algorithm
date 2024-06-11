import java.util.*;
class Solution {
    int[][] map = new int[102][102];
    int[] dx = {1,0,-1,0};
    int[] dy = {0,1,0,-1};
    boolean[][] visited = new boolean[102][102];
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        
        //이동할 수 있는 경로 테두리 1로 표시
        for(int[] rect : rectangle){
            int x1 = rect[0]*2;
            int y1 = rect[1]*2;
            int x2 = rect[2]*2;
            int y2 = rect[3]*2;
            
            for(int x=x1; x<=x2; x++){
                for(int y=y1; y<=y2; y++){
                    if(map[x][y] == 2){continue;}
                    map[x][y] = 2;
                    if(x==x1 || x==x2 || y==y1 || y==y2){map[x][y] = 1;}
                }
            }
        }
        
        Queue<Pos> qu = new LinkedList<>();
        qu.add(new Pos(characterX*2, characterY*2, 0));
        
        while(!qu.isEmpty()){
            Pos pos = qu.poll();
            int x = pos.x;
            int y = pos.y;
            int dist = pos.dist;
            
            if(x == itemX*2 && y == itemY*2){
                answer = dist;
                break;
            }
            
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(!visited[nx][ny] && isGo(nx, ny, map)){
                    visited[nx][ny] = true;
                    qu.add(new Pos(nx, ny, dist+1));
                }
            }
        }
        
        return answer/2;
    }
    
    public boolean isGo(int x, int y, int[][] map){
        return map[x][y] == 1;
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