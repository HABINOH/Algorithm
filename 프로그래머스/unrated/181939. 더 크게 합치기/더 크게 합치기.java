class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        StringBuilder firstSb = new StringBuilder();
        StringBuilder secondSb = new StringBuilder();
        
        firstSb.append(Integer.toString(a) + Integer.toString(b));
        secondSb.append(Integer.toString(b) + Integer.toString(a));
        
        int first = Integer.parseInt(firstSb.toString());
        int second = Integer.parseInt(secondSb.toString());
        
        if(first > second){
            answer = first;
        }else{answer = second;}
        
        return answer;
    }
}