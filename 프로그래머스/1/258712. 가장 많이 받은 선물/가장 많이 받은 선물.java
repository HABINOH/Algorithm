import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int giftLen = friends.length;
        int[] answer = new int[giftLen];
        HashMap<String,Integer> Index = new HashMap<>();
        int[][] story = new int[giftLen][giftLen];
        int[] giftSum = new int[giftLen];
        
        for(int i=0;i<friends.length;i++){ // 초기화
            Index.put(friends[i], i);
        }
        
        for(int i=0;i<gifts.length;i++){
            StringTokenizer stk = new StringTokenizer(gifts[i], " ");
            String A = stk.nextToken();
            String B = stk.nextToken();
            
            int from = Index.get(A);
            int to = Index.get(B);
                
            story[from][to]++;
            giftSum[from]++;
            giftSum[to]--;
        }
        
        for(int i=0;i<friends.length;i++){
            for(int j=0;j<friends.length;j++){
                if(i==j){continue;}
                if(story[i][j] > story[j][i]){
                    answer[i]++;
                }else if(story[i][j] < story[j][i]){
                    answer[j]++;
                }else{
                    if(giftSum[i] > giftSum[j]){
                        answer[i]++;
                    }else if(giftSum[i] < giftSum[j]){
                        answer[j]++;
                    }
                }
            }
        }
        int cnt = 0;
        for(int count : answer){
            cnt = Math.max(count, cnt);
        }
        return cnt/2;
    }
}