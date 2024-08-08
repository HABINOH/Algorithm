import java.io.*;
import java.util.*;
 
public class Main {
    public static class Po{
        int x;
        int y;
        int z;
        public Po(int x,int y,int z) {
            this.x=x;
            this.y=y;
            this.z=z;
        }
    }
    static int dy[] = {-1,0,1,0,0,0};
    static int dx[] = {0,1,0,-1,0,0};
    static int dz[] = {0,0,0,0,1,-1};
    static int L,R,C;
    static char arr[][][];
    static int map[][][];
    static boolean visit[][][],check=false;
    static Po start, end;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            check = false;
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(!st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L==0 && R==0 && C==0) {
                break;
            }
            arr = new char[L][R][C];
            map = new int[L][R][C];
            visit = new boolean[L][R][C];
            
            for(int l=0; l<L; l++) {
                for(int r=0; r<R; r++) {
                    String str = br.readLine();
                    
                    if(str.equals("")) 
                        str = br.readLine();
                        
                    for(int c=0; c<C; c++) {
                        char ch = str.charAt(c);
                        if(ch == 'S') {
                            start = new Po(c,r,l);
                        }else if(ch == 'E') {
                            end = new Po(c,r,l);
                        }
                        arr[l][r][c] = ch;
                    }
                }
            }
            
            bfs(start);
            if(!check) {
                bw.write("Trapped!");
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static void bfs(Po p) throws IOException{
        Queue<Po> queue = new LinkedList<>();
        queue.add(p);
        visit[p.z][p.y][p.x] = true;
        
        while(!queue.isEmpty()) {
            Po tmp = queue.poll();
            if(tmp.x == end.x && tmp.y == end.y && tmp.z == end.z) {
                bw.write("Escaped in "+map[tmp.z][tmp.y][tmp.x]+" minute(s).");
                bw.newLine();
                check = true;
                return;
            }
            
            for(int i=0; i<6; i++) {
                int newX = tmp.x + dx[i];
                int newY = tmp.y + dy[i];
                int newZ = tmp.z + dz[i];
                
                if(inRange(newX, newY, newZ) && !visit[newZ][newY][newX]) {
                    if(arr[newZ][newY][newX]!='#') {
                        visit[newZ][newY][newX] = true;
                        map[newZ][newY][newX] = map[tmp.z][tmp.y][tmp.x] + 1;
                        queue.add(new Po(newX,newY,newZ));
                    }
                }
            }
        }
    }
    static boolean inRange(int newX, int newY, int newZ){
        return 0<=newX && newX<C && 0<=newY && newY<R && 0<=newZ && newZ<L;
    }
}