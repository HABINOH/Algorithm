class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int n = board.length;
        int m = board[0].length;
        
        int[][] delta = new int[n+1][m+1];
        int degree;
        for(int[] sk : skill){
            if(sk[0] == 1){degree = -sk[5];}
            else {degree = sk[5];}
            
            int sr = sk[1], sc = sk[2], er = sk[3], ec = sk[4];
            
            delta[sr][sc] += degree;
            delta[sr][ec+1] += -degree;
            delta[er+1][sc] += -degree;
            delta[er+1][ec+1] += degree;
        }
        
        //left -> right
        for(int i=0; i<=n; i++){
            for(int j=1; j<=m; j++){
                delta[i][j] += delta[i][j-1];
            }
        }
        for(int j=0;j<=m;j++){
            for(int i=1;i<=n;i++){
                delta[i][j] += delta[i-1][j];
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j] += delta[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}