import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[][] map;
    static int[] students;
    static Map<Integer,Set<Integer>> preferences;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());

        map = new int[n][n];
        students = new int[n*n];
        preferences = new HashMap<>();
        for(int i=0;i<n*n;i++){
            stk = new StringTokenizer(br.readLine());
            int student = Integer.parseInt(stk.nextToken());
            students[i] = student;
            preferences.put(student, new HashSet<>());
            for(int j=0;j<4;j++){
                preferences.get(student).add(Integer.parseInt(stk.nextToken()));
            }
        }

        for (int student : students) {
            Seat seat = findSeat(student);
            map[seat.x][seat.y] = student;
        }

        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int count = getStudentSum(i, j, map[i][j]);
                if(count > 0){
                    result += (int) Math.pow(10, count - 1);
                }
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
    static Seat findSeat(int student){
        Seat seat = null;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] > 0){continue;}
                Seat curSeat = new Seat(i, j, getStudentSum(i,j,student), getEmptySum(i,j));
                if(seat == null){
                    seat = curSeat;
                    continue;
                }
                //이전 자리와 현재 자리 비교
                if(seat.compareTo(curSeat) > 0){
                    seat = curSeat;
                }
            }
        }
        return seat;
    }
    static int getEmptySum(int x, int y){
        int cnt = 0;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny)){
                if(map[nx][ny] == 0){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int getStudentSum(int x, int y, int student){
        int cnt = 0;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(inRange(nx, ny)){
                if(preferences.get(student).contains(map[nx][ny])){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static boolean inRange(int x, int y){
        return x>=0 && y>=0 && x<n && y<n;
    }

    static class Seat implements Comparable<Seat> {
        int x;
        int y;
        int sum;
        int empty;
        public Seat(int x, int y, int sum, int empty){
            this.x = x;
            this.y = y;
            this.sum = sum;
            this.empty = empty;
        }

        @Override
        public int compareTo(Seat other){
            //근처 좋아하는 학생 수
            int studentSum = Integer.compare(other.sum, this.sum);
            if(studentSum != 0){
                return studentSum;
            }
            //근처 빈칸 수
            int emptySum = Integer.compare(other.empty, this.empty);
            if(emptySum != 0){
                return emptySum;
            }
            //행(x)
            int xCompare = Integer.compare(this.x, other.x);
            if(xCompare != 0){
                return xCompare;
            }
            //열(y)
            return Integer.compare(this.y, other.y);
        }
    }
}
