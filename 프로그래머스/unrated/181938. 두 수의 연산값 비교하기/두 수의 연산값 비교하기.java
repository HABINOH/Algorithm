class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        
        String str = (Integer.toString(a) + Integer.toString(b));
        String str2 = Integer.toString(a*b*2);
        
        int comp1 = Integer.parseInt(str);
        int comp2 = Integer.parseInt(str2);
        
        if(comp1 < comp2){answer = comp2;}
        else answer = comp1;
        
        return answer;
    }
}