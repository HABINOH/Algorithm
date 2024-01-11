class Solution {
    public int solution(String number) {
        int answer = 0;
        String[] s = number.split("");
        int sum = 0;
        for(int i=0;i<s.length;i++){
            sum += Integer.parseInt(s[i]);
        }
        
        answer =  sum % 9;
        
        return answer;
    }
}