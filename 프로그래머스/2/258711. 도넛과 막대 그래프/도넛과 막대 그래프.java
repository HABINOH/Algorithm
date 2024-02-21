import java.util.*;
class Solution {
    public ArrayList solution(int[][] edges) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] in = new int[1_000_000];
        int[] out = new int[1_000_000];
        
        int maxNode = 0;
        for(int i=0; i<edges.length; i++){
            in[edges[i][1]]++;
            out[edges[i][0]]++;
            maxNode = Math.max(maxNode, Math.max(edges[i][0], edges[i][1]));
        }
        int createNode = 0;
        int stickNode = 0;
        int eightNode = 0;
        for(int node=1;node<=maxNode; node++){
            //새로 생긴 접점 노드는 나가는 것만 2개 이상
            if(out[node] >=2 && in[node] == 0){createNode = node;}
            //막대 노드 --> 나가는거 0개
            else if(out[node] == 0){stickNode++;}
            //8자 노드 --> 나가는거 2개 이상 들어오는거 2개
            else if(in[node] >= 2 && out[node] == 2){eightNode++;}
        }
        int donutNode = out[createNode] - (eightNode + stickNode);

        answer.add(createNode);
        answer.add(donutNode);
        answer.add(stickNode);
        answer.add(eightNode);
        
        return answer;
    }
}